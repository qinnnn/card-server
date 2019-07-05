package com.xxoocode.card.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xxoocode.card.webSocket.WebSocket;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class WebSocketEntity implements Serializable { //房间entity
    @TableId
    private String uuid; //房间uuid
    private WebSocket one; //玩家1
    private Long oneCardId; //玩家1卡包
    private Long oneUserId;
    private WebSocket two; //玩家2
    private Long twoCardId; //玩家2卡包
    private Long twoUserId;
    private Integer type; //当前类型 0为一人等待的房间 1为已匹配完成房间
    private Date createTime;
}
