package com.example.demo.controller.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security/admin")

public class AdminSecurityController {

    @GetMapping
    @ResponseBody
    public String adminHelloPanel() {
        return "This is ADMIN hello panel";
    }
}
