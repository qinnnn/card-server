package com.xxoocode.card.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 卡牌效果表
 * 
 * @author zhuanghaoqin
 * @email zzz
 * @date 2019-05-29 15:33:38
 */
@TableName("card_effect")
public class CardEffectEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 效果id
	 */
	@TableId
	private Long effectId;
	/**
	 * 范围 0为全场 1为敌方全场 2为友方全场 3为敌方全体随从 4为敌方单体随从 5为敌方英雄 6为友方全体随从 7为友方单体随从 8为友方英雄 9为自身（必须为随从才可自身）
	 */
	private Integer range;
	/**
	 * 时机 0为立即，1为回合结束时，2为回合开始时，3为友方随从死亡时，4为敌方随从死亡时
	 */
	private Integer oppor;
	/**
	 * 生命值
	 */
	private Integer effectLife;
	/**
	 * 攻击力
	 */
	private Integer effectAgg;
	/**
	 * 指定类型 0为所有类型，1为野兽牌
	 */
	private Integer effectAppoint;

	/**
	 * 设置：效果id
	 */
	public void setEffectId(Long effectId) {
		this.effectId = effectId;
	}
	/**
	 * 获取：效果id
	 */
	public Long getEffectId() {
		return effectId;
	}
	/**
	 * 设置：范围 0为全场 1为敌方全场 2为友方全场 3为敌方全体随从 4为敌方单体随从 5为敌方英雄 6为友方全体随从 7为友方单体随从 8为友方英雄 9为自身（必须为随从才可自身）
	 */
	public void setRange(Integer range) {
		this.range = range;
	}
	/**
	 * 获取：范围 0为全场 1为敌方全场 2为友方全场 3为敌方全体随从 4为敌方单体随从 5为敌方英雄 6为友方全体随从 7为友方单体随从 8为友方英雄 9为自身（必须为随从才可自身）
	 */
	public Integer getRange() {
		return range;
	}
	/**
	 * 设置：时机 0为立即，1为回合结束时，2为回合开始时，3为友方随从死亡时，4为敌方随从死亡时
	 */
	public void setOppor(Integer oppor) {
		this.oppor = oppor;
	}
	/**
	 * 获取：时机 0为立即，1为回合结束时，2为回合开始时，3为友方随从死亡时，4为敌方随从死亡时
	 */
	public Integer getOppor() {
		return oppor;
	}
	/**
	 * 设置：生命值
	 */
	public void setEffectLife(Integer effectLife) {
		this.effectLife = effectLife;
	}
	/**
	 * 获取：生命值
	 */
	public Integer getEffectLife() {
		return effectLife;
	}
	/**
	 * 设置：攻击力
	 */
	public void setEffectAgg(Integer effectAgg) {
		this.effectAgg = effectAgg;
	}
	/**
	 * 获取：攻击力
	 */
	public Integer getEffectAgg() {
		return effectAgg;
	}
	/**
	 * 设置：指定类型 0为所有类型，1为野兽牌
	 */
	public void setEffectAppoint(Integer effectAppoint) {
		this.effectAppoint = effectAppoint;
	}
	/**
	 * 获取：指定类型 0为所有类型，1为野兽牌
	 */
	public Integer getEffectAppoint() {
		return effectAppoint;
	}
}
