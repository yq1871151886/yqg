package com.fh.bean.po;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserParameter implements Serializable {

    private String realName;
    private String deptId;
    private String deptName;
    private Integer sex;
    private Integer isValid;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date minDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date maxDate;

}
