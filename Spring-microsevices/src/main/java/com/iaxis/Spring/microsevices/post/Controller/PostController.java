package com.iaxis.Spring.microsevices.post.Controller;

import com.iaxis.Spring.microsevices.exception.ResourceNotFound;
import com.iaxis.Spring.microsevices.login.entity.Login;
import com.iaxis.Spring.microsevices.login.service.LoginService;
import com.iaxis.Spring.microsevices.post.entity.Post;
import com.iaxis.Spring.microsevices.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author aditya.chakma
 * @since 14 Jan, 2025
 */
@RestController
@RequestMapping("/posts")
public class PostController {

    private final LoginService loginService;

    private final PostService postService;

    @Autowired
    public PostController(PostService postService, LoginService loginService) {
        this.postService = postService;
        this.loginService = loginService;
    }

    @GetMapping("/{login_id}/list")
    public List<Post> getPosts(@PathVariable("login_id") Long loginId) {
        Login login = loginService.find(loginId);

        if (login == null) {
            throw new ResourceNotFound("Invalid login");
        }

        return postService.findAllByLogin(login);
    }

    @PostMapping("/{login_id}/create")
    public Post createPost(@PathVariable("login_id") Long loginId,
                           @RequestBody Post post) {

        Login login = loginService.find(loginId);

        if (login == null) {
            throw new ResourceNotFound("Invalid login");
        }

        return postService.save(post, login);
    }

}
