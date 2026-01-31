package com.dev.produtosapi.controller;

import com.dev.produtosapi.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @PostMapping
    public String login(@RequestBody User user){
        if ("admin".equals(user.getUsername()) && "1234".equals(user.getPassword())){
            return "Login Feito...";
        } else {
            return "Login Recusado...";
        }
    }
}
