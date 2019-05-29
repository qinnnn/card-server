package com.xxoocode.card.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxoocode.card.dao.UserDao;
import com.xxoocode.card.entity.UserEntity;
import com.xxoocode.card.service.UserService;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void saveUser(UserEntity user) {
        user.setCreateTime(new Date());
        String salt = RandomStringUtils.randomAlphanumeric(20);
        user.setPassword(new Sha256Hash(user.getPassword(), salt).toHex());
        user.setSalt(salt);
        this.save(user);
    }
}
