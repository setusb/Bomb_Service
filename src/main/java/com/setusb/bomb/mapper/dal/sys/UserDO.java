package com.setusb.bomb.mapper.dal.sys;

import com.baomidou.mybatisplus.annotation.TableName;
import com.setusb.bomb.mapper.dal.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@TableName("sys_user")
@EqualsAndHashCode(callSuper = true)
public class UserDO extends BaseDO {

    private String id;

    private String userName;

    private String password;
}
