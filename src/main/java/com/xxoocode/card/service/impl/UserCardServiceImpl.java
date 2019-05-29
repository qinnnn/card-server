package com.xxoocode.card.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxoocode.card.dao.UserCardDao;
import com.xxoocode.card.entity.UserCardEntity;
import com.xxoocode.card.service.UserCardService;
import org.springframework.stereotype.Service;
import java.util.Map;


@Service("userCardService")
public class UserCardServiceImpl extends ServiceImpl<UserCardDao, UserCardEntity> implements UserCardService {


}
