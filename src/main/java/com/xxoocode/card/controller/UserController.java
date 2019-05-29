package com.xxoocode.card.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxoocode.card.entity.UserEntity;
import com.xxoocode.card.service.UserService;
import com.xxoocode.card.service.UserTokenService;
import com.xxoocode.common.utils.R;
import com.xxoocode.common.validator.ValidatorUtils;
import com.xxoocode.common.validator.group.AddGroup;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserTokenService userTokenService;

    @PostMapping("/login")
    public R login(@RequestBody UserEntity userEntity){

        UserEntity user = userService.getOne(new QueryWrapper<UserEntity>().eq("user_name",userEntity.getUserName()));

        if (user == null || !user.getPassword().equals(new Sha256Hash(userEntity.getPassword(), user.getSalt()).toHex())) {
            return R.error("账号或密码不正确");
        }

        //账号锁定
        if (user.getStatus() != 0) {
            return R.error("账号已被锁定,请联系管理员");
        }

        R r = userTokenService.createToken(user.getUserId());

//        UserEntity user = userService.getUserById(userId);
        return r;
    }

    @RequestMapping("/list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params){
        List<UserEntity> userEntityList = userService.list(new QueryWrapper<UserEntity>().eq("status",0).eq("del_flag",0));
        return R.ok().put("list",userEntityList);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("sys:user:save")
    public R save(@RequestBody UserEntity sysUser) {
        ValidatorUtils.validateEntity(sysUser, AddGroup.class);

        Date date = new Date();
        sysUser.setUpdateTime(date);
        sysUser.setCreateTime(date);
        userService.saveUser(sysUser);

        //生成token，并保存到数据库
        R r = userTokenService.createToken(sysUser.getUserId());
        return r;
    }
}
