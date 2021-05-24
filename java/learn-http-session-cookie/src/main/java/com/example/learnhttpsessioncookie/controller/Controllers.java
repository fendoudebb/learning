package com.example.learnhttpsessioncookie.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * zbj: created on 2021/5/23 10:02.
 */
@RestController
public class Controllers {

    @GetMapping("/login")
    public String login(@RequestParam("u") String u, HttpSession session, HttpServletRequest request) {
        session.setAttribute("name", u);
        String s = request.changeSessionId();
        System.out.println(s);
        return "OK";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "SUCCESS";
    }

    @GetMapping("/info")
    public String info(HttpSession session) {
        return (String) session.getAttribute("name");
    }

}
