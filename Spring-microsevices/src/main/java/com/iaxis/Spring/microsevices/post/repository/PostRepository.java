package com.iaxis.Spring.microsevices.post.repository;

import com.iaxis.Spring.microsevices.login.entity.Login;
import com.iaxis.Spring.microsevices.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author aditya.chakma
 * @since 14 Jan, 2025
 */
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("FROM post WHERE login = :login")
    List<Post> findAllByLogin(Login login);
}
