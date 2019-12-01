package com.fh.bean;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName("r_electric")
@Data
public class Electric implements Serializable {
    @TableId(value = "id",type = IdType.UUID)
    private String id;
    @TableField(value = "pid")
    private String pid;
    @TableField(value = "electricName")
    private String name;
    @TableField(value = "isValid")
    private Integer isValid;

}
