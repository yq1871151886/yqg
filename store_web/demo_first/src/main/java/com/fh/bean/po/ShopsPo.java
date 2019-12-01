package com.fh.bean.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ShopsPo implements Serializable {


    private String name;

    private String subtitle;


    private String detail;

    private Double price;

    private Integer stock;

    private Integer status;

    private Integer limit;

    private Integer page;


}
