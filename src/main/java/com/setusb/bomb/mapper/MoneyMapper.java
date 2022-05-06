package com.setusb.bomb.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.setusb.bomb.mapper.dal.sys.MoneyDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MoneyMapper extends BaseMapper<MoneyDO> {

    default MoneyDO getMoney(String userId) {
        return selectOne(new QueryWrapper<MoneyDO>().eq("user_id", userId));
    }
}
