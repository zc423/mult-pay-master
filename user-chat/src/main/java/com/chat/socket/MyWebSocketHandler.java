package com.chat.socket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyWebSocketHandler extends TextWebSocketHandler {

    private Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>(); // 维护session
    private static Long id = 1l;


    /**
     * 连接建立后，把客户端session对象加入map中
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.put(String.valueOf(id++), session);
//    sessions.put(session.getId(), session);
    }

    /**
     * 连接关闭后，将客户端session对象从map中移除
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session.getId());
    }

    /**
     * 处理接收到的文本消息，并发送给指定的目标客户端
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        String[] payloads = payload.split(",");
        WebSocketSession targetSession = sessions.get(payloads[0]);
        targetSession.sendMessage(new TextMessage(payloads[1]));
    }
}