package com.iaxis.Spring.microsevices.login.service;

import com.iaxis.Spring.microsevices.login.entity.Login;
import com.iaxis.Spring.microsevices.login.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author aditya.chakma
 * @since 13 Jan, 2025 3:26 PM
 */
@Service
public class LoginService {

    private LoginRepository loginRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public List<Login> getLoginList() {
        return loginRepository.findAll();
    }

    public Login find(Long id) {
        return loginRepository.findById(id).orElse(null);
    }

}
