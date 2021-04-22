package com.exmaple.ws;


import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.net.InetSocketAddress;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zbj created on 2021/4/16 22:05.
 */
@ServerEndpoint(value = "/test/ws/{username}", configurator = WebSocketServerConfigurator.class)
public class WebSocketServer {

    private static final AtomicLong COUNT = new AtomicLong(0);

    private static final ConcurrentHashMap<String, Session> map = new ConcurrentHashMap<>(1 << 10);

    static {
        System.out.println("WebSocketServer 静态代码块 加载了, thread name#" + Thread.currentThread().getName() + ", thread id#" + Thread.currentThread().getId());
    }

    public WebSocketServer() {
        System.out.println("WebSocketServer 构造方法 加载了, thread name#" + Thread.currentThread().getName() + ", thread id#" + Thread.currentThread().getId());
    }

    @OnOpen
    public void onOpen(@PathParam("username") String username, Session session) {
        HttpSession httpSession = (HttpSession) session.getUserProperties().get(HttpSession.class.getName());
        System.out.println("ClientIP#" + httpSession.getAttribute("ClientIP"));

        InetSocketAddress remoteAddress = WebsocketUtil.getRemoteAddress(session);
        System.out.println("remoteAddress: " + remoteAddress.toString());

//        httpSession.getAttribute("ClientIP");

        map.putIfAbsent(username, session);
        COUNT.incrementAndGet();
        // 最大超时时间 60 秒
        session.setMaxIdleTimeout(TimeUnit.MINUTES.toMillis(5));
        session.setMaxBinaryMessageBufferSize(8192 * 1024); // 8KB
        session.setMaxTextMessageBufferSize(8192 * 1024); // 字符数
        session.getAsyncRemote().sendText("123");
    }

    @OnClose
    public void onClose(@PathParam("username") String username, Session session, CloseReason closeReason) {
        map.remove(username, session);
        COUNT.decrementAndGet();
        System.out.printf("onClose username#%s Session#%s closed because of %s%n", username,session.toString(), closeReason);
    }

    @OnError
    public void onError(Session session, Throwable t) {
        System.out.println("onError#" + session);
        t.printStackTrace();
    }

    @OnMessage
    public String onMessage(@PathParam("username") String username, String message, Session session) {
        System.out.println("onMessage username#" + username + "#" + message);
        return message + "#" + ThreadLocalRandom.current().nextInt(1 << 20);
    }
}
