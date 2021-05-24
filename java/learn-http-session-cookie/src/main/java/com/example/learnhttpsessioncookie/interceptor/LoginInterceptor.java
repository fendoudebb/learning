package com.example.learnhttpsessioncookie.interceptor;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String reqPath = httpServletRequest.getServletPath();
        // 只有返回true才会继续向下执行，返回false取消当前请求
        HttpSession session = httpServletRequest.getSession();
        System.out.println("isRequestedSessionIdFromCookie#" + httpServletRequest.isRequestedSessionIdFromCookie());
        System.out.println("isRequestedSessionIdFromURL#" + httpServletRequest.isRequestedSessionIdFromURL());
        System.out.println("isRequestedSessionIdValid#" + httpServletRequest.isRequestedSessionIdValid());
        System.out.println("getRequestedSessionId#" + httpServletRequest.getRequestedSessionId());
//        httpServletRequest.
        if (session == null || StringUtils.isEmpty(session.getAttribute("name"))) {
            System.out.println("access#" + reqPath + ", not logged in, return");
            httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }
        System.out.println("session is new?#" + session.isNew());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}