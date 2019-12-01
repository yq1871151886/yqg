package com.fh.bean.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class BrandPo implements Serializable {
    private String brandName;
    private Integer status;

    private Integer page;
    private Integer limit;


}
