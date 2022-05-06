package com.setusb.bomb.config.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.setusb.bomb.mapper.dal.BaseDO;
import com.setusb.bomb.utils.TokenUtil;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;
import java.util.Objects;

public class MetaObjectHandlerConfig implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        if (Objects.nonNull(metaObject) && metaObject.getOriginalObject() instanceof BaseDO base) {
            String tokenUserId = TokenUtil.getTokenUserId();
            Date current = new Date();
            base.setCreateBy(tokenUserId);
            base.setCreateDate(current);
            base.setUpdateBy(tokenUserId);
            base.setUpdateDate(current);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        String tokenUserId = TokenUtil.getTokenUserId();
        setFieldValByName("updateDate", new Date(), metaObject);
        setFieldValByName("updateBy", tokenUserId, metaObject);
    }
}
