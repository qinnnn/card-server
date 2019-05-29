package com.xxoocode.card.dao;

import com.xxoocode.card.entity.CardEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 卡牌表
 * 
 * @author zhuanghaoqin
 * @email zzz
 * @date 2019-05-29 15:33:38
 */
@Mapper
public interface CardDao extends BaseMapper<CardEntity> {
	
}
