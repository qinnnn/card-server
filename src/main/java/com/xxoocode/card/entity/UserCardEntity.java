package com.xxoocode.card.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户卡牌关联表
 * 
 * @author zhuanghaoqin
 * @email zzz
 * @date 2019-05-29 15:33:38
 */
@TableName("user_card")
public class UserCardEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long userCardId;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 卡牌id
	 */
	private Long cardId;
	/**
	 * 卡牌所有数量
	 */
	private Integer number;

	/**
	 * 设置：
	 */
	public void setUserCardId(Long userCardId) {
		this.userCardId = userCardId;
	}
	/**
	 * 获取：
	 */
	public Long getUserCardId() {
		return userCardId;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：卡牌id
	 */
	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}
	/**
	 * 获取：卡牌id
	 */
	public Long getCardId() {
		return cardId;
	}
	/**
	 * 设置：卡牌所有数量
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}
	/**
	 * 获取：卡牌所有数量
	 */
	public Integer getNumber() {
		return number;
	}
}
