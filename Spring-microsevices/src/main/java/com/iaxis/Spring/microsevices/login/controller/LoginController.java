package com.iaxis.Spring.microsevices.login.controller;

import com.iaxis.Spring.microsevices.login.entity.Login;
import com.iaxis.Spring.microsevices.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * @author aditya.chakma
 * @since 13 Jan, 2025 3:29 PM
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/list")
    public List<Login> getLoginList() {
        return loginService.getLoginList();
    }

    @GetMapping("/{id}")
    public Login getLogin(@PathVariable Long id) {
        return loginService.find(id);
    }

    @PostMapping
    public ResponseEntity<?> saveLogin(@RequestBody Login login) {
        login = loginService.saveOrUpdate(login);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .build(login.getId());

        return ResponseEntity.created(location).build();
    }

}
