package com.setusb.bomb.config.web;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Component
@Aspect
@Slf4j
public class AopAspect {

    @Pointcut("execution( public * com.setusb.bomb.service..*.*(..))")
    public void aopPointCut() {
    }

    @Around("aopPointCut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            Object result = joinPoint.proceed();
            long end = System.currentTimeMillis();
            log.info("执行 " + joinPoint + " 耗时为 : " + (end - start) + " ms");
            return result;
        } catch (Throwable e) {
            long end = System.currentTimeMillis();
            log.info("执行 " + joinPoint + " 耗时为 : " + (end - start) + " ms 抛出了异常 : " + e.getMessage());
            throw e;
        }
    }
}
