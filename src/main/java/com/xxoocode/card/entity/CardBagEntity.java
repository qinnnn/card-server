package com.xxoocode.card.entity;



import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户卡包表
 * 
 * @author zhuanghaoqin
 * @email zzz
 * @date 2019-05-29 15:33:38
 */
@TableName("card_bag")
public class CardBagEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 卡包id
	 */
	@TableId
	private Long cardBagId;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 卡包名
	 */
	private String bagName;
	/**
	 * 卡包类型 0普通包
	 */
	private Integer bagType;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 设置：卡包id
	 */
	public void setCardBagId(Long cardBagId) {
		this.cardBagId = cardBagId;
	}
	/**
	 * 获取：卡包id
	 */
	public Long getCardBagId() {
		return cardBagId;
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
	 * 设置：卡包名
	 */
	public void setBagName(String bagName) {
		this.bagName = bagName;
	}
	/**
	 * 获取：卡包名
	 */
	public String getBagName() {
		return bagName;
	}
	/**
	 * 设置：卡包类型 0普通包
	 */
	public void setBagType(Integer bagType) {
		this.bagType = bagType;
	}
	/**
	 * 获取：卡包类型 0普通包
	 */
	public Integer getBagType() {
		return bagType;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
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
