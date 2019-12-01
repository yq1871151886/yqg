package com.fh.store_product_api.bean.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ElectricVo implements Serializable {
    private Integer id;
    private Integer pid;
    private String name;
    private Integer isValid;

}
