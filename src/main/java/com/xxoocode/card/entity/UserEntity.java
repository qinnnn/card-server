package com.xxoocode.card.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("user")
public class UserEntity implements Serializable {
    @TableId
    private Long userId;
    private String name;
    private String userName;
    private String password;
    private String salt;
    private String mobile;
    private Date updateTime;
    private Date createTime;
    private Integer status;
    @TableLogic
    private Integer delFlag;
}
