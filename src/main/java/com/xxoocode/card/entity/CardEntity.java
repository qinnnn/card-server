package com.xxoocode.card.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 卡牌表
 * 
 * @author zhuanghaoqin
 * @email zzz
 * @date 2019-05-29 15:33:38
 */
@TableName("card")
public class CardEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long cardId;
	/**
	 * 卡牌名字
	 */
	private String cardName;
	/**
	 * 卡牌费水晶量
	 */
	private Integer crystal;
	/**
	 * 卡牌类型 0为随从牌 1为法术牌
	 */
	private Integer type;
	/**
	 * 随从牌的生命值
	 */
	private Integer life;
	/**
	 * 随从牌的攻击力
	 */
	private Integer agg;
	/**
	 * 伤害值（效果的数值）
	 */
	private Integer hurt;
	/**
	 * 效果类型id
	 */
	private String effectIds;
	/**
	 * 随从牌的类型 0为普通 1为野兽
	 */
	private Integer entType;
	/**
	 * 稀有度 0为普通 1为稀有 2为史诗 3为传说
	 */
	private Integer rarity;
	/**
	 * 介绍
	 */
	private String introduce;
	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 设置：
	 */
	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}
	/**
	 * 获取：
	 */
	public Long getCardId() {
		return cardId;
	}
	/**
	 * 设置：卡牌名字
	 */
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	/**
	 * 获取：卡牌名字
	 */
	public String getCardName() {
		return cardName;
	}
	/**
	 * 设置：卡牌费水晶量
	 */
	public void setCrystal(Integer crystal) {
		this.crystal = crystal;
	}
	/**
	 * 获取：卡牌费水晶量
	 */
	public Integer getCrystal() {
		return crystal;
	}
	/**
	 * 设置：卡牌类型 0为随从牌 1为法术牌
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：卡牌类型 0为随从牌 1为法术牌
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：随从牌的生命值
	 */
	public void setLife(Integer life) {
		this.life = life;
	}
	/**
	 * 获取：随从牌的生命值
	 */
	public Integer getLife() {
		return life;
	}
	/**
	 * 设置：随从牌的攻击力
	 */
	public void setAgg(Integer agg) {
		this.agg = agg;
	}
	/**
	 * 获取：随从牌的攻击力
	 */
	public Integer getAgg() {
		return agg;
	}
	/**
	 * 设置：伤害值（效果的数值）
	 */
	public void setHurt(Integer hurt) {
		this.hurt = hurt;
	}
	/**
	 * 获取：伤害值（效果的数值）
	 */
	public Integer getHurt() {
		return hurt;
	}
	/**
	 * 设置：效果类型id
	 */
	public void setEffectIds(String effectIds) {
		this.effectIds = effectIds;
	}
	/**
	 * 获取：效果类型id
	 */
	public String getEffectIds() {
		return effectIds;
	}
	/**
	 * 设置：随从牌的类型 0为普通 1为野兽
	 */
	public void setEntType(Integer entType) {
		this.entType = entType;
	}
	/**
	 * 获取：随从牌的类型 0为普通 1为野兽
	 */
	public Integer getEntType() {
		return entType;
	}
	/**
	 * 设置：稀有度 0为普通 1为稀有 2为史诗 3为传说
	 */
	public void setRarity(Integer rarity) {
		this.rarity = rarity;
	}
	/**
	 * 获取：稀有度 0为普通 1为稀有 2为史诗 3为传说
	 */
	public Integer getRarity() {
		return rarity;
	}
	/**
	 * 设置：介绍
	 */
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	/**
	 * 获取：介绍
	 */
	public String getIntroduce() {
		return introduce;
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
}
