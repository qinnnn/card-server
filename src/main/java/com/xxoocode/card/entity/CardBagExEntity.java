package com.xxoocode.card.entity;



import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户卡包表
 * 
 * @author zhuanghaoqin
 * @email zzz
 * @date 2019-05-29 15:33:38
 */
@TableName("card_bag")
public class CardBagExEntity extends CardBagEntity {
	private List<CardBagDetailsEntity> cardBagDetailsEntityList;


	public List<CardBagDetailsEntity> getCardBagDetailsEntityList() {
		return cardBagDetailsEntityList;
	}

	public void setCardBagDetailsEntityList(List<CardBagDetailsEntity> cardBagDetailsEntityList) {
		this.cardBagDetailsEntityList = cardBagDetailsEntityList;
	}
}
