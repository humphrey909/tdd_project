package com.example.tdd_project.data.handler;

import com.example.tdd_project.data.entity.User;

public interface UserDataHandler {
    User saveUserEntity(
            Long userId, String userName);

    User getUserEntity(Long userId);
}
