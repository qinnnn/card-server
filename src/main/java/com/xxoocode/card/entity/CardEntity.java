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
	 * 卡牌图片
	 */
	private String cardImg;
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
	 * 随从牌的攻击次数
	 */
	private Integer speed;
	/**
	 * 是否有影响效果
	 */
	private Integer isEffect;
	/**
	 * 随从牌的类型 0为普通 1为野兽
	 */
	private Integer entType;
	/**
	 * 随从特殊类型 0为无特殊类型 1为冲锋 2为嘲讽 3为圣盾
	 */
	private Integer specialType;
	/**
	 * 稀有度 0为普通 1为稀有 2为史诗 3为传说
	 */
	private Integer rarity;
	/**
	 * 范围 0为全场 1为敌方全场 2为友方全场 3为敌方全体随从 4为敌方单体随从 5为敌方英雄 6为友方全体随从 7为友方单体随从 8为友方英雄 9为自身（必须为随从才可自身）
	 */
	private Integer ranges;
	/**
	 * 时机 0为立即，1为回合结束时，2为回合开始时，3为友方随从死亡时，4为敌方随从死亡时
	 */
	private Integer oppor;
	/**
	 * 影响生命值
	 */
	private Integer effectLife;
	/**
	 * 影响攻击力
	 */
	private Integer effectAgg;
	/**
	 * 影响攻击次数
	 */
	private Integer effectSpeed;
	/**
	 * 影响随从特殊类型 0为无特殊类型 1为冲锋 2为嘲讽 3为圣盾
	 */
	private Integer effectSpecialType;
	/**
	 * 指定类型 0为所有类型，1为野兽牌
	 */
	private Integer effectAppoint;
	/**
	 * 影响是否突破原先的数据 0不突破 1突破
	 */
	private Integer effectBreach;
	/**
	 * 关键字 用,分割
	 */
	private String keyword;
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

	public String getCardImg() {
		return cardImg;
	}

	public void setCardImg(String cardImg) {
		this.cardImg = cardImg;
	}

	public Integer getRanges() {
		return ranges;
	}

	public void setRanges(Integer ranges) {
		this.ranges = ranges;
	}

	public Integer getOppor() {
		return oppor;
	}

	public void setOppor(Integer oppor) {
		this.oppor = oppor;
	}

	public Integer getEffectLife() {
		return effectLife;
	}

	public void setEffectLife(Integer effectLife) {
		this.effectLife = effectLife;
	}

	public Integer getEffectAgg() {
		return effectAgg;
	}

	public void setEffectAgg(Integer effectAgg) {
		this.effectAgg = effectAgg;
	}

	public Integer getEffectAppoint() {
		return effectAppoint;
	}

	public void setEffectAppoint(Integer effectAppoint) {
		this.effectAppoint = effectAppoint;
	}

	public Integer getIsEffect() {
		return isEffect;
	}

	public void setIsEffect(Integer isEffect) {
		this.isEffect = isEffect;
	}

	public Integer getEffectBreach() {
		return effectBreach;
	}

	public void setEffectBreach(Integer effectBreach) {
		this.effectBreach = effectBreach;
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getEffectSpeed() {
		return effectSpeed;
	}

	public void setEffectSpeed(Integer effectSpeed) {
		this.effectSpeed = effectSpeed;
	}

	public Integer getSpecialType() {
		return specialType;
	}

	public void setSpecialType(Integer specialType) {
		this.specialType = specialType;
	}

	public Integer getEffectSpecialType() {
		return effectSpecialType;
	}

	public void setEffectSpecialType(Integer effectSpecialType) {
		this.effectSpecialType = effectSpecialType;
	}
}
