package com.example.tdd_project.data.handler.repository;

import com.example.tdd_project.data.dto.UserDto;
import com.example.tdd_project.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {


    UserDto save(UserDto user);
    UserDto findById(Long id);
}