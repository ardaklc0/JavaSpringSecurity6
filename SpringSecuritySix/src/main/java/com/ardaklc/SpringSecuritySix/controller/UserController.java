package com.ardaklc.SpringSecuritySix.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/index")
    public String index(Model model){
        return "Have a good day. Please sign up!";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin(Model model){
        return "Welcome admin!";
    }

    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public String dashboard(Model model){
        return "This is a special message for clients";
    }
}
