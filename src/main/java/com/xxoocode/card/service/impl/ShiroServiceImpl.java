

package com.xxoocode.card.service.impl;

import com.xxoocode.card.dao.UserDao;
import com.xxoocode.card.dao.UserTokenDao;
import com.xxoocode.card.entity.UserEntity;
import com.xxoocode.card.entity.UserTokenEntity;
import com.xxoocode.card.service.ShiroService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("shiroService")
public class ShiroServiceImpl implements ShiroService {
    @Autowired
    private UserDao sysUserDao;
    @Autowired
    private UserTokenDao sysUserTokenDao;

//    @Override
//    public Set<String> getUserPermissions(long userId, int moduleType) {
//        List<String> permsList;
//
//        //系统管理员，拥有最高权限
//        if (userId == Constant.SUPER_ADMIN) {
//            List<SysMenuEntity> menuList = sysMenuDao.selectList(new QueryWrapper<SysMenuEntity>().eq("status", 0).eq(true, "module_type", moduleType));
//            permsList = new ArrayList<>(menuList.size());
//            for (SysMenuEntity menu : menuList) {
//                permsList.add(menu.getPermission());
//            }
//        } else {
//
//            permsList = sysUserDao.queryAllPermssion(userId, moduleType);
//        }
//        //用户权限列表
//        Set<String> permsSet = new HashSet<>();
//        for (String perms : permsList) {
//            if (StringUtils.isBlank(perms)) {
//                continue;
//            }
//            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
//        }
//        return permsSet;
//    }

    @Override
    public UserTokenEntity queryByToken(String token) {
        return sysUserTokenDao.queryByToken(token);
    }

    @Override
    public UserEntity queryUser(Long userId) {
        return sysUserDao.selectById(userId);
    }


    @Override
    public UserEntity queryUserInfo(Long userId) {
        return sysUserDao.selectById(userId);
    }
}
