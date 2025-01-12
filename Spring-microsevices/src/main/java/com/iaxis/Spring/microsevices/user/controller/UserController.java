package com.iaxis.Spring.microsevices.user.controller;

import com.iaxis.Spring.microsevices.exception.UserNotFoundException;
import com.iaxis.Spring.microsevices.user.dto.User;
import com.iaxis.Spring.microsevices.user.helper.UserHelper;
import com.iaxis.Spring.microsevices.user.service.UserDaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * @author aditya.chakma
 * @since 06 Jan, 2025 3:36 PM
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserDaoService userDaoService;

    private final UserHelper userHelper;

    @Autowired
    public UserController(UserDaoService userDaoService, UserHelper userHelper) {
        this.userDaoService = userDaoService;
        this.userHelper = userHelper;
    }

    @GetMapping("/list")
    public List<User> getList() {
        return userDaoService.getUserList();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id) {
        User user = userDaoService.getUserById(id);

        if (user == null) {
            throw new UserNotFoundException("id: " + id + " not found");
        }

        return user;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody User user,
                                        BindingResult result) {

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(userHelper.getErrorDetails(result));
        }

        user = userDaoService.saveUser(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PostMapping("/v2")
    public ResponseEntity<?> createUserV2(@Valid @RequestBody User user,
                                          BindingResult result) {

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(userHelper.getErrorDetails(result));
        }

        user = userDaoService.saveUser(user);

        EntityModel<User> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder.linkTo(methodOn(this.getClass()).getList());
        entityModel.add(linkBuilder.withRel("all-users"));

        WebMvcLinkBuilder deleteLinkBuilder = WebMvcLinkBuilder.linkTo(methodOn(this.getClass()).deleteUser(user.getId()));
        entityModel.add(deleteLinkBuilder.withRel("delete-user").withType("Delete"));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(location).body(entityModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        userDaoService.deleteUserById(id);

        return ResponseEntity.noContent().build();
    }

}
