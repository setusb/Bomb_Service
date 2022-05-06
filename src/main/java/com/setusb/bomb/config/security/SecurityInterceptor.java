package com.setusb.bomb.config.security;

import com.setusb.bomb.common.TokenData;
import com.setusb.bomb.common.Translation;
import com.setusb.bomb.config.exception.ResponseException;
import com.setusb.bomb.mapper.dal.sys.UserDO;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SecurityInterceptor {

    public void intercept(String token) {
        // 有关安全校验写入此处
        if (token.isEmpty()) {
            throw new ResponseException(Translation.PLEASE_LOG_IN_FIRST);
        }
        UserDO tokenMap = (UserDO) TokenData.get(token);
        Optional.ofNullable(tokenMap).orElseThrow(() -> new ResponseException(Translation.TOKEN_IS_INVALID));
    }
}
