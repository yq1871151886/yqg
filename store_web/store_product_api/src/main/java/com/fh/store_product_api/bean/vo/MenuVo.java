package com.fh.store_product_api.bean.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class MenuVo implements Serializable {


    private String id;

    private String name;

    private String pid;

    private String image;

    private String ele;

}
