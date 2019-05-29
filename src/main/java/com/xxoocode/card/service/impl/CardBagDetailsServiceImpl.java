package com.xxoocode.card.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxoocode.card.dao.CardBagDetailsDao;
import com.xxoocode.card.entity.CardBagDetailsEntity;
import com.xxoocode.card.service.CardBagDetailsService;
import org.springframework.stereotype.Service;


@Service("cardBagDetailsService")
public class CardBagDetailsServiceImpl extends ServiceImpl<CardBagDetailsDao, CardBagDetailsEntity> implements CardBagDetailsService {


}
