package com.example.tdd_project.controller;

import com.example.tdd_project.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.*;

import org.slf4j.Logger;

@RestController
@RequestMapping("/api/v1/user-api")
public class UserController {

    private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {this.userService = userService; }

//    @GetMapping(value = "/user/{userId}")
//    public User

    // http://localhost:8080/api/v1/user-api/user/{userId}
    @GetMapping(value = "/user/{userId}")
    public UserDto getUser(@PathVariable Long userId) {

        long startTime = System.currentTimeMillis();
//        LOGGER.info("[getProduct] perform {} of Around Hub API.");
        LOGGER.info("[getProduct] perform {} of Around Hub API.", "getProduct");

        UserDto userDto = userService.getUser(userId);

        LOGGER.info("[getProduct] perform {} of Around Hub API.", userDto.getId());
        LOGGER.info("[getProduct] perform {} of Around Hub API.", userDto.getName());



        LOGGER.info(
                "[getProduct] Response :: productId = {}, productName = {}, Response Time = {}ms",
                userDto.getId(),
                userDto.getName(),
                (System.currentTimeMillis() - startTime));
        return userDto;
    }

    // http://localhost:8080/api/v1/user-api/user
//    @Parameters({
//            @Parameter(
//                    name = "X-AUTH-TOKEN",
//                    description = "로그인 성공 후 access_token",
//                    required = true,
//                    schema = @Schema(implementation = String.class),
//                    in = ParameterIn.HEADER)
//    })
    @PostMapping(value = "/user")
    public ResponseEntity<UserDto> createProduct(@Valid @RequestBody UserDto userDto) {

        LOGGER.info("[createProduct] perform {} of Around Hub API.", "createProduct");

        // Validation Code Example
        if (userDto.getId() == 0) {
            LOGGER.error("[createProduct] failed Response :: productId is Empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(userDto);
        }

        Long userId = userDto.getId();
        String userName = userDto.getName();
//        int productPrice = userDto.getProductPrice();
//        int productStock = userDto.getProductStock();

        UserDto response =
                userService.saveUser(userId, userName);

        LOGGER.info(
                "[createProduct] Response >> productId : {}, productName : {}",
                response.getId(),
                response.getName());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
