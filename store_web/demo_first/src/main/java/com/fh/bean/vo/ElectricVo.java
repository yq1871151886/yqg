package com.fh.bean.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ElectricVo implements Serializable {
    private String id;
    private String pid;
    private String name;
    private Integer isValid;

}
