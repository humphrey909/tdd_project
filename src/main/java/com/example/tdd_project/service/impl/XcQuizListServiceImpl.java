package com.example.tdd_project.service.impl;

import com.example.tdd_project.data.dto.UserDto;
import com.example.tdd_project.data.dto.XcQuizListDto;
import com.example.tdd_project.data.entity.User;
import com.example.tdd_project.data.entity.XcQuizList;
import com.example.tdd_project.data.handler.UserDataHandler;
import com.example.tdd_project.data.handler.XcQuizListDataHandler;
import com.example.tdd_project.exception.BadRequestException;
import com.example.tdd_project.service.UserService;
import com.example.tdd_project.service.XcQuizListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class XcQuizListServiceImpl implements XcQuizListService {
    private final Logger LOGGER = LoggerFactory.getLogger(XcQuizListServiceImpl.class);

//    UserDataHandler userDataHandler;
    XcQuizListDataHandler xcQuizListDataHandler;

     @Autowired
     public XcQuizListServiceImpl(UserDataHandler userDataHandler){
         this.xcQuizListDataHandler = xcQuizListDataHandler;
     }

//    @Override
//    public UserDto saveUser(Long userId, String userName) {
//        LOGGER.info("[saveProduct] productDataHandler 로 상품 정보 저장 요청");
//        User user =
//                userDataHandler.saveUserEntity(userId, userName);
//
//        LOGGER.info("[saveProduct] Entity 객체를 DTO 객체로 변환 작업. productId : {}", user.getId());
//        UserDto userDto =
//                new UserDto(user.getId(), user.getName());
//
//        return userDto;
//    }

    @Override
    public XcQuizListDto getQuizList(int idx) {
        LOGGER.info("[getUser] userDataHandler 로 상품 정보 조회 요청");
        XcQuizList quizList = xcQuizListDataHandler.getXcQuizListEntity(idx);

        if (quizList.getIdx() <= 0) {
            throw new BadRequestException("유효하지 않은 userId입니다.");
        }

        LOGGER.info("[getUser] Entity 객체를 DTO 객체로 변환 작업. productId : {}", quizList.getIdx());
        XcQuizListDto xcQuizListDto =
                new XcQuizListDto(quizList.getIdx(), quizList.getType(), quizList.getTitle(), quizList.getQText(), quizList.getQImg(), quizList.getSolution(), quizList.getShowSolution());
        return xcQuizListDto;
    }
}
