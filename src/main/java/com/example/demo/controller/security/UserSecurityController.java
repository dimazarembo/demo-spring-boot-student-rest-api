package com.example.demo.controller.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/security/user")
public class UserSecurityController {

    @GetMapping
    @ResponseBody
    public String userHelloPanel(Principal principal) {
        return "This is success test to get USER panel. So hello " + principal.getName();
    }

    @GetMapping
    @RequestMapping("/me")
    public List<String> me() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return List.of("name: " + auth.getName(), "isAuthenticated: " + auth.isAuthenticated(), "roles: " + auth.getAuthorities().toString());
    }
}
