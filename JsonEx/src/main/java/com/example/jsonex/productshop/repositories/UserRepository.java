package com.example.jsonex.productshop.repositories;

import com.example.jsonex.productshop.entities.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
