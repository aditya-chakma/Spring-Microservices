package com.iaxis.Spring.microsevices.login.entity;

import com.iaxis.Spring.microsevices.post.entity.Post;
import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Objects;

/**
 * @author aditya.chakma
 * @since 13 Jan, 2025 2:54 PM
 */
@Entity(name = "login")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String email;

    private String firstName;

    private String lastName;

    @Valid
    @OneToMany(mappedBy = "login")
    List<Post> posts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String emai) {
        this.email = emai;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login login = (Login) o;
        return Objects.equals(id, login.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
