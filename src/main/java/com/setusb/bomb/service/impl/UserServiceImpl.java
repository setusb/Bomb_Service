package com.setusb.bomb.service.impl;

import com.setusb.bomb.common.TokenData;
import com.setusb.bomb.controller.vo.user.UserGetUserInfoRespVO;
import com.setusb.bomb.mapper.dal.sys.MoneyDO;
import com.setusb.bomb.mapper.dal.sys.UserDO;
import com.setusb.bomb.mapper.MoneyMapper;
import com.setusb.bomb.service.IUserService;
import com.setusb.bomb.utils.TokenUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private MoneyMapper moneyMapper;

    @Override
    public UserGetUserInfoRespVO getUserInfo() {
        UserGetUserInfoRespVO resp = new UserGetUserInfoRespVO();
        String tokenUserId = TokenUtil.getTokenUserId();
        MoneyDO money = moneyMapper.getMoney(tokenUserId);
        resp.setMoney(money.getMoney());
        resp.setUserInfo((UserDO) TokenData.get(TokenUtil.getToken()));
        return resp;
    }
}
