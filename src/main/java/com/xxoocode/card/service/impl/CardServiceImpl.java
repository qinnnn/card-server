package com.xxoocode.card.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxoocode.card.dao.CardDao;
import com.xxoocode.card.entity.CardEntity;
import com.xxoocode.card.service.CardService;
import org.springframework.stereotype.Service;
import java.util.Map;


@Service("cardService")
public class CardServiceImpl extends ServiceImpl<CardDao, CardEntity> implements CardService {


}
