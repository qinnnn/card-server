package com.xxoocode.card.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.xxoocode.card.entity.CardBagEntity;
import com.xxoocode.card.entity.CardBagExEntity;

import java.util.List;

/**
 * 用户卡包表
 *
 * @author zhuanghaoqin
 * @email zzz
 * @date 2019-05-29 15:33:38
 */
public interface CardBagService extends IService<CardBagEntity> {
    List<CardBagExEntity> getBagList();
}

