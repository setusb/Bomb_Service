package com.setusb.bomb.service.impl;

import cn.hutool.core.util.IdUtil;
import com.setusb.bomb.common.TokenData;
import com.setusb.bomb.common.Translation;
import com.setusb.bomb.config.exception.ResponseException;
import com.setusb.bomb.controller.vo.auth.AuthLoginReqVO;
import com.setusb.bomb.controller.vo.auth.AuthLoginRespVO;
import com.setusb.bomb.controller.vo.auth.AuthRegisterReqVO;
import com.setusb.bomb.mapper.dal.sys.MoneyDO;
import com.setusb.bomb.mapper.dal.sys.UserDO;
import com.setusb.bomb.mapper.MoneyMapper;
import com.setusb.bomb.mapper.UserMapper;
import com.setusb.bomb.service.IAuthService;
import com.setusb.bomb.utils.EncryptUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;

@Service("authService")
public class AuthServiceImpl implements IAuthService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private MoneyMapper moneyMapper;

    @Override
    public AuthLoginRespVO login(AuthLoginReqVO vo) {
        UserDO userByUsername = userMapper.getUserByUserNameAndPassword(vo.getUserName(), EncryptUtil.encrypt(vo.getPassword()));
        Optional.ofNullable(userByUsername).orElseThrow(() -> new RuntimeException(Translation.WRONG_USER_NAME_OR_PASSWORD));
        AuthLoginRespVO resp = new AuthLoginRespVO();
        resp.setToken(IdUtil.simpleUUID());
        TokenData.put(resp.getToken(), userByUsername);
        return resp;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void register(AuthRegisterReqVO vo) {
        if (Optional.ofNullable(userMapper.getUserByUserName(vo.getUserName())).isPresent()) {
            throw new ResponseException(Translation.USERNAME_ALREADY_EXISTS);
        }
        UserDO user = new UserDO();
        user.setId(IdUtil.simpleUUID());
        user.setUserName(vo.getUserName());
        user.setPassword(EncryptUtil.encrypt(vo.getPassword()));
        userMapper.insert(user);
        MoneyDO money = new MoneyDO();
        money.setId(IdUtil.simpleUUID());
        money.setUserId(user.getId());
        money.setMoney(0L);
        moneyMapper.insert(money);
    }
}
