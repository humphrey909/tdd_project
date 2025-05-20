package com.example.tdd_project.data.handler.impl;


import com.example.tdd_project.data.entity.XcQuizList;
import com.example.tdd_project.data.handler.XcQuizListDataHandler;
import com.example.tdd_project.service.impl.XcQuizListServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class XcQuizListDataHandlerImpl implements XcQuizListDataHandler {
    private final Logger LOGGER = LoggerFactory.getLogger(XcQuizListServiceImpl.class);

    @Override
    public XcQuizList getXcQuizListEntity(int idx) {
        return null;
    }

//    UserDAO userDAO;

//    @Autowired
//    public XcQuizListDataHandlerImpl(UserDAO userDAO) {
//        this.userDAO = userDAO;
//    }
//
////    @Override
////    public User saveUserEntity(Long userId, String userName) {
////        LOGGER.debug("[saveProductEntity] 매개변수를 통해 Entity 객체 생성");
////        User user = new User(userId, userName);
////
////        LOGGER.info("[saveProductEntity] productDAO로 Product 정보 저장 요청. productId : {}", userId);
////        return userDAO.saveUser(user);
////    }
////
//    @Override
//    public XcQuizList getXcQuizListEntity(int idx) {
//        LOGGER.info("[saveProductEntity] productDAO로 Product 정보 요청. productId : {}", idx);
//        return null;
//    }
}


