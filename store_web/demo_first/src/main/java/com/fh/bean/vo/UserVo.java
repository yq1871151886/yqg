package com.fh.bean.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
@Data
public class UserVo implements Serializable {
    private String  id;                   //char not null,
    private String  loginName;            //varchar(0),
    private String  realName;             //varchar(0),
    private String  loginPwd;             //varchar(0),
    private String  email;                //varchar(0),
    private Integer isValid;              //int,
    private Integer job;                  //int,
    private String jobName;                  //int,
    private String  phone;                //varchar(0),
    private String  deptId;               //char,
    private String  deptName;               //char,
    private String  telPhone;             //varchar(0),
    private String  idCard;               //varchar(0),
    private String  imgUrl;               //varchar(0),
    private Integer sex;                  //int,
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;             //date,

}
