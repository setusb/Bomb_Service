package com.setusb.bomb.config.web;

import com.setusb.bomb.common.Security;
import com.setusb.bomb.config.security.SecurityInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class HandlerInterceptorConfig implements HandlerInterceptor {

    @Resource
    private SecurityInterceptor securityInterceptor;

    private final static String AUTHORIZATION = "authorization";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(AUTHORIZATION);
        if (!(handler instanceof HandlerMethod handlerMethod)) {
            return true;
        }
        Method method = handlerMethod.getMethod();
        if (method.isAnnotationPresent(Security.class)) {
            securityInterceptor.intercept(token);
            return true;
        }
        return true;
    }
}
