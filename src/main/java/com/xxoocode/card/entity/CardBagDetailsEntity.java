package com.xxoocode.card.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 卡包详情表
 * 
 * @author zhuanghaoqin
 * @email zzz
 * @date 2019-05-29 15:33:38
 */
@TableName("card_bag_details")
public class CardBagDetailsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long cardBagDetailsId;
	/**
	 * 所属卡包id
	 */
	private Long cardBagId;
	/**
	 * 卡牌id
	 */
	private Long cardId;
	/**
	 * 此卡牌的数量
	 */
	private Integer number;
	private Integer rarity;
	private Integer crystal;
	private String cardName;
	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 设置：
	 */
	public void setCardBagDetailsId(Long cardBagDetailsId) {
		this.cardBagDetailsId = cardBagDetailsId;
	}
	/**
	 * 获取：
	 */
	public Long getCardBagDetailsId() {
		return cardBagDetailsId;
	}
	/**
	 * 设置：所属卡包id
	 */
	public void setCardBagId(Long cardBagId) {
		this.cardBagId = cardBagId;
	}
	/**
	 * 获取：所属卡包id
	 */
	public Long getCardBagId() {
		return cardBagId;
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
	 * 设置：此卡牌的数量
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}
	/**
	 * 获取：此卡牌的数量
	 */
	public Integer getNumber() {
		return number;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	public Integer getRarity() {
		return rarity;
	}

	public void setRarity(Integer rarity) {
		this.rarity = rarity;
	}

	public Integer getCrystal() {
		return crystal;
	}

	public void setCrystal(Integer crystal) {
		this.crystal = crystal;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
}
