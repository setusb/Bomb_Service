package com.setusb.bomb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.setusb.bomb.mapper.dal.sys.VersionDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VersionMapper extends BaseMapper<VersionDO> {
}
