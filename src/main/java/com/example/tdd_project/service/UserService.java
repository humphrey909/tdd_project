package com.example.tdd_project.service;

//public class UserService {
//    private final UserRepository userRepository;
//
//    // 생성자 주입
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public User registerUser(Long id, String name) {
//        User user = new User(id, name);
//        return userRepository.save(user);
//    }
//}

public interface UserService {

    UserDto saveUser(Long userId, String userName);

    UserDto getUser(Long userId);
}