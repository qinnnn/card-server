package com.xxoocode.card.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxoocode.card.entity.UserTokenEntity;
import com.xxoocode.common.utils.R;

/**
 * 系统用户登陆token表
 *
 * @author BetraySmile
 * @email zzz
 * @date 2019-03-18 15:50:55
 */
public interface UserTokenService extends IService<UserTokenEntity> {

    /**
     * 生成token
     *
     * @param userId      用户ID
     */
    R createToken(Long userId);

    /**
     * 退出，修改token值
     *
     * @param userId 用户ID
     */
    void logout(Long userId);

}

