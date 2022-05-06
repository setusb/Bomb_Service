package com.setusb.bomb.mapper.dal;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseDO implements Serializable {

    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date createDate;

    @TableField(fill = FieldFill.INSERT)
    private String updateBy;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateDate;
}
