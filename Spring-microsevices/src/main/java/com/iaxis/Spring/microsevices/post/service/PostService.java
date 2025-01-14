package com.iaxis.Spring.microsevices.post.service;

import com.iaxis.Spring.microsevices.login.entity.Login;
import com.iaxis.Spring.microsevices.post.entity.Post;
import com.iaxis.Spring.microsevices.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author aditya.chakma
 * @since 14 Jan, 2025
 */
@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    public List<Post> findAllByLogin(Login login) {
        return postRepository.findAllByLogin(login);
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public Post save(Post post, Login login) {
        post.setLogin(login);
        return postRepository.save(post);
    }

}
