package com.api.crud.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor    //esto es para hacer obligatorip que se agregue el constructor con todos loa argumentos
public class AuthController {

    @PostMapping("/login")
    public String login() {
        return "Login succefull";
    }

    @PostMapping("/register")
    public String register() {
        return "Register succefull";
    }

}
