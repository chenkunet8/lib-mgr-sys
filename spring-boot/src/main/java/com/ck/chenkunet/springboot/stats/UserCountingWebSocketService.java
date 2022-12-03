package com.ck.chenkunet.springboot.stats;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ServerEndpoint("/websocket/stats")
public class UserCountingWebSocketService {

    private Session session;

    private static CopyOnWriteArraySet<Session> webSocketSet = new CopyOnWriteArraySet();

    public static void sendUserCount(){
        for(Session i : webSocketSet){
            try {
                i.getBasicRemote().sendText(webSocketSet.size()+"");
                System.out.println("发送成功："+webSocketSet.size());
            } catch (IOException e) {
                System.out.println("发送消息异常："+e);
            }
        }
    }

    @OnOpen
    public void OnOpen(Session session){
        this.session = session;
        webSocketSet.add(session);
        System.out.println("已连接："+session.getId());
    }

    @OnClose
    public void OnClose(){
        webSocketSet.remove(this.session);
        System.out.println("已断开："+this.session.getId());
    }

    @OnMessage
    public void onMessage(String message){
        System.out.println("收到消息："+message);
    }

}
