package com.example.redirect_forward.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class RedirectForwardController {

    @GetMapping("/test1")
    public String test1() {
        return "redirect:http://127.0.0.1:8080/test2";
    }

    @GetMapping("/test2")
    public String test2() {
        return "redirect:http://127.0.0.1:8080/test3";
    }

    @GetMapping("/test3")
    @ResponseBody
    public String test3() {
        return "来自test3的结果";
    }

    @GetMapping("/test4")
    public String test4() {
        return "forward:/test3";
    }

    @GetMapping("/test-forward")
    public void testForward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // request.getRequestDispatcher("https://www.baidu.com").forward(request, response); // 无法跨域 forward
        request.getRequestDispatcher("https://www.baidu.com").forward(request, response);
    }

    @GetMapping("/test-redirect")
    public void testRedirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("https://www.baidu.com");
    }

}
