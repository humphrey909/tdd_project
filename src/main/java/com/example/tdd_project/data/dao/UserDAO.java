package com.example.tdd_project.data.dao;

import com.example.tdd_project.data.entity.User;

public interface UserDAO {
    User saveUser(User user);
    User getUser(Long userId);
}
