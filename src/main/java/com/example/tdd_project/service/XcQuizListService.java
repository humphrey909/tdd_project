package com.example.tdd_project.service;

import com.example.tdd_project.data.dto.XcQuizListDto;

public interface XcQuizListService {

//    XcQuizListDto saveUser(Long userId, String userName);

    XcQuizListDto getQuizByIdx(int idx);
}