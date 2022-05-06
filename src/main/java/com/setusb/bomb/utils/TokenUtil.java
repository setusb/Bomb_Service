package com.setusb.bomb.utils;

import com.setusb.bomb.common.TokenData;
import com.setusb.bomb.mapper.dal.sys.UserDO;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.Optional;

public class TokenUtil {

    public static String getTokenUserId() {
        String token = Objects.requireNonNull(getRequest()).getHeader("authorization");
        UserDO user = (UserDO) TokenData.get(token);
        return Optional.ofNullable(user).isEmpty() ? null : user.getId();
    }

    public static String getToken() {
        return Objects.requireNonNull(getRequest()).getHeader("authorization");
    }

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        return requestAttributes == null ? null : requestAttributes.getRequest();
    }
}
