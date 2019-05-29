package com.xxoocode.card.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxoocode.card.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

    /**
     * 获取用户信息
     * @param userId
     * @return
     */
    UserEntity getUserInfoById(Long userId);
}
