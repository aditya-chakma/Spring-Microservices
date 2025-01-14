package com.iaxis.Spring.microsevices.login.controller;

import com.iaxis.Spring.microsevices.login.entity.Login;
import com.iaxis.Spring.microsevices.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author aditya.chakma
 * @since 13 Jan, 2025 3:29 PM
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/list")
    public List<Login> getLoginList() {
        return loginService.getLoginList();
    }

    @GetMapping("/{id}")
    public Login getLogin(Long id) {
        return loginService.find(id);
    }

}
