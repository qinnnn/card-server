package com.xxoocode.card.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxoocode.card.dao.UserTokenDao;
import com.xxoocode.card.entity.UserTokenEntity;
import com.xxoocode.card.oauth2.TokenGenerator;
import com.xxoocode.card.service.UserTokenService;
import com.xxoocode.common.utils.R;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service("userTokenService")
public class UserTokenServiceImpl extends ServiceImpl<UserTokenDao, UserTokenEntity> implements UserTokenService {
    //12小时后过期
    private final static int EXPIRE = 3600 * 12;

    @Override
    public R createToken(Long userId) {
        //生成一个token
        String token = TokenGenerator.generateValue();

        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

        //判断是否生成过token
        UserTokenEntity tokenEntity = this.getOne(new QueryWrapper<UserTokenEntity>().eq("user_id", userId));
        if (tokenEntity == null) {
            tokenEntity = new UserTokenEntity();
            tokenEntity.setUserId(userId);
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);

            //保存token
            this.save(tokenEntity);
        } else {
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);

            //更新token
            this.update(tokenEntity, new UpdateWrapper<UserTokenEntity>()
                    .eq("user_id", userId));
        }

        R r = R.ok().put("token", token).put("expire", EXPIRE);

        return r;
    }

    @Override
    public void logout(Long userId) {
        //生成一个token
        String token = TokenGenerator.generateValue();

        //修改token
        UserTokenEntity tokenEntity = new UserTokenEntity();
        tokenEntity.setUserId(userId);
        tokenEntity.setToken(token);
        this.removeById(tokenEntity);
    }

    @Override
    public UserTokenEntity queryByToken(String token) {
        return baseMapper.queryByToken(token);
    }
}
