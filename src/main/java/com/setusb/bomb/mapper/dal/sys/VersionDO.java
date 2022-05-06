package com.setusb.bomb.mapper.dal.sys;

import com.baomidou.mybatisplus.annotation.TableName;
import com.setusb.bomb.mapper.dal.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@TableName("sys_version")
@EqualsAndHashCode(callSuper = true)
public class VersionDO extends BaseDO {

    private String id;

    private String version;

    private String checked;
}
