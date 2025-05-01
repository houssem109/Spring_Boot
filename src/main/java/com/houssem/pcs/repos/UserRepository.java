package com.houssem.pcs.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.houssem.pcs.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername (String username);
}