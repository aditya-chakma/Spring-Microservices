package com.iaxis.Spring.microsevices.user.service;

import com.iaxis.Spring.microsevices.user.dto.User;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author aditya.chakma
 * @since 06 Jan, 2025 3:32 PM
 */
@Service
public class UserDaoService {

    // return a static list for now
    public List<User> getUserList() {
        List<User> userList = new ArrayList<>();

        userList.add(new User(1, "Aditya", LocalDate.of(1996, 2, 29)));
        userList.add(new User(2, "Larma", LocalDate.of(1997, 2, 28)));
        LocalDate.now();

        return userList;
    }
}
