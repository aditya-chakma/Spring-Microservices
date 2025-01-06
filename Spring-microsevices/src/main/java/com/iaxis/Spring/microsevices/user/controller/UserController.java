package com.iaxis.Spring.microsevices.user.controller;

import com.iaxis.Spring.microsevices.user.dto.User;
import com.iaxis.Spring.microsevices.user.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author aditya.chakma
 * @since 06 Jan, 2025 3:36 PM
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserDaoService userDaoService;

    @Autowired
    public UserController(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping("/list")
    public List<User> getList() {
        return userDaoService.getUserList();
    }
}
