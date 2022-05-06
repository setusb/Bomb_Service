package com.setusb.bomb.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.setusb.bomb.mapper.dal.sys.UserDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserDO> {

    default UserDO getUserByUserNameAndPassword(String userName, String password) {
        return selectOne(new QueryWrapper<UserDO>().eq("user_name", userName).eq("password", password));
    }

    default UserDO getUserByUserName(String userName) {
        return selectOne(new QueryWrapper<UserDO>().eq("user_name", userName));
    }
}
