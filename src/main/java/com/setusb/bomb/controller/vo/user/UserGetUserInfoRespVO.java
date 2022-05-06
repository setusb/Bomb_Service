package com.setusb.bomb.controller.vo.user;

import com.setusb.bomb.mapper.dal.sys.UserDO;
import lombok.Data;

@Data
public class UserGetUserInfoRespVO {

    private UserDO userInfo;

    private Long money;
}
