/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package com.xxoocode.card.service;

import com.xxoocode.card.entity.UserEntity;
import com.xxoocode.card.entity.UserTokenEntity;

import java.util.Set;

/**
 * shiro相关接口
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface ShiroService {

    /**
     * 获取用户权限列表
     */
//    Set<String> getUserPermissions(long userId, int moduleType);

    UserTokenEntity queryByToken(String token);

    /**
     * 根据用户ID，查询用户
     * @param userId
     */
    UserEntity queryUser(Long userId);

    /**
     * 根据用户ID，查询用户登录信息
     * @param userId
     */
    UserEntity queryUserInfo(Long userId);
}
