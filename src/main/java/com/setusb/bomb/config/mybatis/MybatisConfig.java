package com.setusb.bomb.config.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.setusb.bomb.mapper")
public class MybatisConfig {

    @Bean
    public MetaObjectHandler defaultMetaObjectHandler(){
        return new MetaObjectHandlerConfig();
    }
}
