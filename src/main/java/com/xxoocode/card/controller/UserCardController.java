package com.xxoocode.card.controller;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxoocode.card.entity.UserCardEntity;
import com.xxoocode.card.service.UserCardService;
import com.xxoocode.common.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




/**
 * 用户卡牌关联表
 *
 * @author zhuanghaoqin
 * @email zzz
 * @date 2019-05-29 15:33:38
 */
@RestController
@RequestMapping("usercard")
public class UserCardController {
    @Autowired
    private UserCardService userCardService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:usercard:list")
    public R list(@RequestParam Map<String, Object> params){
        List<UserCardEntity> page = userCardService.list(new QueryWrapper<UserCardEntity>());

        return R.ok().put("list", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userCardId}")
    @RequiresPermissions("generator:usercard:info")
    public R info(@PathVariable("userCardId") Long userCardId){
			UserCardEntity userCard = userCardService.getById(userCardId);

        return R.ok().put("userCard", userCard);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:usercard:save")
    public R save(@RequestBody UserCardEntity userCard){
			userCardService.save(userCard);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:usercard:update")
    public R update(@RequestBody UserCardEntity userCard){
			userCardService.updateById(userCard);

        return R.ok();
    }

}
