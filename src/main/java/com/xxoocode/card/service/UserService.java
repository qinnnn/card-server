package com.xxoocode.card.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxoocode.card.entity.UserEntity;

public interface UserService extends IService<UserEntity> {
    /**
     * 保存
     * @param userEntity
     */
    void saveUser(UserEntity userEntity);

    /**
     * 获取用户信息
     * @param userId
     * @return
     */
    UserEntity getUserInfoById(Long userId);
}
