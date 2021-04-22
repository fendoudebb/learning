package com.exmaple.ws;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebListener
public class MyServletListener implements ServletRequestListener {

    public MyServletListener() {
        System.out.println("MyServletListener 构造方法 加载了, thread name#" + Thread.currentThread().getName() + ", thread id#" + Thread.currentThread().getId());
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        HttpSession session = request.getSession();
        System.out.println("requestInitialized session = " + session + ", getRequestURL#" + request.getRequestURL().toString() + ", getRemoteHost#" + request.getRemoteHost() + ", getRemoteAddr#" + request.getRemoteAddr());
        session.setAttribute("ClientIP", request.getRemoteAddr());//把HttpServletRequest中的IP地址放入HttpSession中，关键字可任取，此处为ClientIP
        String host = request.getHeader("Host");
        String xRealIP = request.getHeader("X-Real-IP");
        String  xForwardedFor = request.getHeader("X-Forwarded-For");

        System.out.println("host#" + host + ", X-Real-IP#" + xRealIP + ", X-Forwarded-For#" + xForwardedFor);
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("requestDestroyed sre = " + sre);
    }

}