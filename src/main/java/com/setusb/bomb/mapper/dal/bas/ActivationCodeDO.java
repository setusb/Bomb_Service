package com.setusb.bomb.mapper.dal.bas;

import com.baomidou.mybatisplus.annotation.TableName;
import com.setusb.bomb.mapper.dal.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@TableName("bas_activation_code")
@EqualsAndHashCode(callSuper = true)
public class ActivationCodeDO extends BaseDO {

    private String id;

    private String code;

    private String checked;
}
