package com.setusb.bomb.controller;

import com.setusb.bomb.common.Response;
import com.setusb.bomb.controller.vo.auth.AuthLoginReqVO;
import com.setusb.bomb.controller.vo.auth.AuthRegisterReqVO;
import com.setusb.bomb.service.IAuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Resource
    private IAuthService iAuthService;

    @PostMapping("/login")
    public Response login(@RequestBody AuthLoginReqVO vo) {
        return Response.success(iAuthService.login(vo));
    }

    @PostMapping("/register")
    public Response register(@RequestBody AuthRegisterReqVO vo) {
        iAuthService.register(vo);
        return Response.success();
    }
}
