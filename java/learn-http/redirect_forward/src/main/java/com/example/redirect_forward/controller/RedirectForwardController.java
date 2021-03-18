package com.example.redirect_forward.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
