package com.setusb.bomb.controller;

import com.setusb.bomb.common.Response;
import com.setusb.bomb.common.Security;
import com.setusb.bomb.service.IUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService iUserService;

    @Security
    @PostMapping("/getUserInfo")
    public Response getUserInfo() {
        return Response.success(iUserService.getUserInfo());
    }
}
