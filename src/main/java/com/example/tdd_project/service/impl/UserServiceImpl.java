package com.example.tdd_project.service.impl;

import com.example.tdd_project.data.dto.UserDto;
import com.example.tdd_project.data.entity.User;
import com.example.tdd_project.data.handler.UserDataHandler;
import com.example.tdd_project.exception.BadRequestException;
import com.example.tdd_project.service.UserService;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

@Service
public class UserServiceImpl implements UserService {
    private final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

     UserDataHandler userDataHandler;

     @Autowired
     public UserServiceImpl(UserDataHandler userDataHandler){
         this.userDataHandler = userDataHandler;
     }

    @Override
    public UserDto saveUser(Long userId, String userName) {
        LOGGER.info("[saveProduct] productDataHandler 로 상품 정보 저장 요청");
        User user =
                userDataHandler.saveUserEntity(userId, userName);

        LOGGER.info("[saveProduct] Entity 객체를 DTO 객체로 변환 작업. productId : {}", user.getId());
        UserDto userDto =
                new UserDto(user.getId(), user.getName());

        return userDto;
    }

    @Override
    public UserDto getUser(Long userId) {
        LOGGER.info("[getUser] userDataHandler 로 상품 정보 조회 요청");
        User user = userDataHandler.getUserEntity(userId);

        if (user.getId() == null || user.getId() <= 0) {
            throw new BadRequestException("유효하지 않은 userId입니다.");
        }

        LOGGER.info("[getUser] Entity 객체를 DTO 객체로 변환 작업. productId : {}", user.getId());
        UserDto userDto =
                new UserDto(user.getId(), user.getName());

        return userDto;
    }
}
