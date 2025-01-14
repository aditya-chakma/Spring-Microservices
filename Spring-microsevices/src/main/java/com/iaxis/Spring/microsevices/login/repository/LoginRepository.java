package com.iaxis.Spring.microsevices.login.repository;

import com.iaxis.Spring.microsevices.login.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author aditya.chakma
 * @since 13 Jan, 2025 3:25 PM
 */
public interface LoginRepository extends JpaRepository<Login, Long> {
}
