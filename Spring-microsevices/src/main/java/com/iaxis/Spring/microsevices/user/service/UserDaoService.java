package com.iaxis.Spring.microsevices.user.service;

import com.iaxis.Spring.microsevices.exception.UserNotFoundException;
import com.iaxis.Spring.microsevices.user.dto.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author aditya.chakma
 * @since 06 Jan, 2025 3:32 PM
 */
@Service
public class UserDaoService {

    private static final List<User> userList = new ArrayList<>();

    private static int userIdCounter = 0;

    static {
        userList.add(new User(++userIdCounter, "Aditya", LocalDate.of(1996, 2, 29)));
        userList.add(new User(++userIdCounter, "Larma", LocalDate.of(1997, 2, 28)));
        userList.add(new User(++userIdCounter, "Mike", LocalDate.of(1998, 2, 28)));
    }

    // return a static list for now
    public List<User> getUserList() {
        return userList;
    }

    public User getUserById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);

        return getUserList().stream()
                .filter(predicate)
                .findFirst()
                .orElse(null);
    }

    public User saveUser(User user) {
        user.setId(++userIdCounter);
        userList.add(user);

        return user;
    }

    public User deleteUserById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);

        User user = getUserById(id);

        if (user == null) {
            throw new UserNotFoundException("id: " + id + " not found");
        }

        userList.remove(user);

        return user;
    }

}
