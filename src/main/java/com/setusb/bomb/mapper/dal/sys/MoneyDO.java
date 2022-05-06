package com.setusb.bomb.mapper.dal.sys;

import com.baomidou.mybatisplus.annotation.TableName;
import com.setusb.bomb.mapper.dal.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@TableName("sys_money")
@EqualsAndHashCode(callSuper = true)
public class MoneyDO extends BaseDO {

    private String id;

    private String userId;

    private Long money;
}
