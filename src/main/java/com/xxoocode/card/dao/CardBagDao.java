package com.xxoocode.card.dao;

import com.xxoocode.card.entity.CardBagEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxoocode.card.entity.CardBagExEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户卡包表
 * 
 * @author zhuanghaoqin
 * @email zzz
 * @date 2019-05-29 15:33:38
 */
@Mapper
public interface CardBagDao extends BaseMapper<CardBagEntity> {
    List<CardBagExEntity> getBagList(Long userId);
}
