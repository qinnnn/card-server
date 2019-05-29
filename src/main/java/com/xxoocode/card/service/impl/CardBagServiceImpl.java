package com.xxoocode.card.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxoocode.card.dao.CardBagDao;
import com.xxoocode.card.entity.CardBagEntity;
import com.xxoocode.card.service.CardBagService;
import org.springframework.stereotype.Service;
import java.util.Map;


@Service("cardBagService")
public class CardBagServiceImpl extends ServiceImpl<CardBagDao, CardBagEntity> implements CardBagService {


}
