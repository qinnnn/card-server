package com.xxoocode.card.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxoocode.card.entity.UserTokenEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统用户登陆token表
 *
 * @author BetraySmile
 * @email zzz
 * @date 2019-03-18 15:50:55
 */
@Mapper
public interface UserTokenDao extends BaseMapper<UserTokenEntity> {

    /**
     * 根据token查询登陆信息
     *
     * @param token
     * @return
     */
    UserTokenEntity queryByToken(String token);
}
