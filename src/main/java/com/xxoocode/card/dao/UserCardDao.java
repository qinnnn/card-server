package com.xxoocode.card.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxoocode.card.entity.UserCardEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户卡牌关联表
 * 
 * @author zhuanghaoqin
 * @email zzz
 * @date 2019-05-29 15:33:38
 */
@Mapper
public interface UserCardDao extends BaseMapper<UserCardEntity>{
	
}
