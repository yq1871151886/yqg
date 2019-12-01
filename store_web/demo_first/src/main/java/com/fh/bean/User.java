package com.fh.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@TableName("t_user")
@Data
public  class User implements Serializable {
    @TableId(value = "id",type = IdType.UUID)
    private String  id;                   //char not null,
    @TableField(value = "loginName",exist = true)
    private String  loginName;            //varchar(0),
    @TableField(value = "realName",exist = true)
    private String  realName;             //varchar(0),
    @TableField(value = "loginPwd",exist = true)
    private String  loginPwd;             //varchar(0),
    @TableField(value = "email",exist = true)
    private String  email;                //varchar(0),
    @TableField(value = "isValid",exist = true)
    private Integer isValid;              //int,
    @TableField(value = "job",exist = true)
    private Integer job;                  //int,
    @TableField(value = "phone",exist = true)
    private String  phone;                //varchar(0),
    @TableField(value = "deptId",exist = true)
    private String  deptId;               //char,
    @TableField(value = "telPhone",exist = true)
    private String  telPhone;             //varchar(0),
    @TableField(value = "idCard",exist = true)
    private String  idCard;               //varchar(0),
    @TableField(value = "sex")
    private Integer sex;                  //int,
    @TableField(value = "birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date    birthday;             //date,
    @TableField(value = "imgUrl")
    private String    imgUrl;             //date,

}
