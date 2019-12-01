package com.fh.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;


@TableName("t_commdity")
@Data
public class Commdity implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField(value = "commdityName")
    private String commdityName;

    @TableField(value = "title")
    private String title;

    @TableField(value = "price")
    private Double price;

    @TableField(value = "stock")
    private Integer stock;

    @TableField(value = "status")
    private Integer status;

    @TableField(value = "brand")
    private Integer brand;

    @TableField(value = "description")
    private String description;

    @TableField(value = "image")
    private String image;
}
