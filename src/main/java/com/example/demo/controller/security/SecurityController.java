package com.example.demo.controller.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/security")
public class SecurityController {

    @GetMapping
    @ResponseBody
    public String hello(){
        return "This is security block. It's for authentication users only.";
    }
}
