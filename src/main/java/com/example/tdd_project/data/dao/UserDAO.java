package com.example.tdd_project.data.dao;

public interface UserDAO {
    User saveUser(User user);
    User getUser(Long userId);
}
