package com.setusb.bomb.config.websocket;

import com.setusb.bomb.common.TokenData;
import com.setusb.bomb.mapper.dal.sys.UserDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@ServerEndpoint(value = "/websocket/connection/{token}")
@Component
public class WebSocketConnection {

    private static final AtomicInteger ONLINE_COUNT = new AtomicInteger(0);

    private static final Map<String, Session> USER_SESSION_MAP = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("token") String token) {
        ONLINE_COUNT.incrementAndGet();
        try {
            if (token.isEmpty()) {
                session.close();
            }
            if (Optional.ofNullable((UserDO) TokenData.get(token)).isEmpty()) {
                session.close();
            }
            USER_SESSION_MAP.put(token, session);
            log.info("有新连接加入：{}，当前在线人数为：{}", session.getId(), ONLINE_COUNT.get());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @OnClose
    public void onClose(Session session, @PathParam("token") String token) {
        ONLINE_COUNT.decrementAndGet();
        USER_SESSION_MAP.remove(token);
        log.info("有一连接关闭：{}，当前在线人数为：{}", session.getId(), ONLINE_COUNT.get());
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("服务端收到客户端[{}]的消息:{}", session.getId(), message);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误");
        error.printStackTrace();
    }

    private void sendMessage(String message, Session toSession) {
        try {
            log.info("服务端给客户端[{}]发送消息{}", toSession.getId(), message);
            toSession.getBasicRemote().sendText(message);
        } catch (Exception e) {
            log.error("服务端发送消息给客户端失败");
        }
    }

}
