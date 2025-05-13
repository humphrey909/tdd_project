package com.example.tdd_project.data.dao.impl;

import com.example.tdd_project.data.dao.UserDAO;
import com.example.tdd_project.data.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class UserDAOImpl implements UserDAO {
    private final Logger LOGGER = LoggerFactory.getLogger(UserDAOImpl.class);


    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public User getUser(Long userId) {
        return null;
    }
}
