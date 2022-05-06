package com.setusb.bomb.service;

import com.setusb.bomb.controller.vo.auth.AuthLoginReqVO;
import com.setusb.bomb.controller.vo.auth.AuthLoginRespVO;
import com.setusb.bomb.controller.vo.auth.AuthRegisterReqVO;

public interface IAuthService {

    AuthLoginRespVO login(AuthLoginReqVO vo);

    void register(AuthRegisterReqVO vo);
}
