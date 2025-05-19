package com.example.tdd_project.service.impl;

import com.example.tdd_project.data.dto.XcQuizListDto;
import com.example.tdd_project.data.entity.XcQuizList;
import com.example.tdd_project.data.handler.XcQuizListDataHandler;
import com.example.tdd_project.data.repository.XcQuizListRepository;
import com.example.tdd_project.exception.BadRequestException;
import com.example.tdd_project.service.XcQuizListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class XcQuizListServiceImpl implements XcQuizListService {
    private final Logger LOGGER = LoggerFactory.getLogger(XcQuizListServiceImpl.class);

//    UserDataHandler userDataHandler;
    XcQuizListDataHandler xcQuizListDataHandler;

    private final XcQuizListRepository quizListRepository;

     @Autowired
     public XcQuizListServiceImpl(XcQuizListRepository quizListRepository){
         this.quizListRepository = quizListRepository;
     }

//    @Override
//    public XcQuizListDto getQuizList(int idx) {
//        LOGGER.info("[getUser] userDataHandler 로 상품 정보 조회 요청");
//        XcQuizList quizList = xcQuizListDataHandler.getXcQuizListEntity(idx);
//
//        if (quizList.getIdx() <= 0) {
//            throw new BadRequestException("유효하지 않은 userId입니다.");
//        }
//
//        LOGGER.info("[getUser] Entity 객체를 DTO 객체로 변환 작업. productId : {}", quizList.getIdx());
//        XcQuizListDto xcQuizListDto =
//                new XcQuizListDto(quizList.getIdx(), quizList.getType(), quizList.getTitle(), quizList.getQText(), quizList.getQImg(), quizList.getSolution(), quizList.getShowSolution());
//        return xcQuizListDto;
//    }

//    @Override
//    public XcQuizListDto getQuizByIdx(int idx) {
//        return null;
//    }

    @Override
    public XcQuizListDto getQuizByIdx(int idx) {
        LOGGER.info("[getProduct] perform {} of Around Hub API.", idx);

        Optional<XcQuizList> result = Optional.ofNullable(quizListRepository.findByIdx(idx));  // <- 이건 Optional.empty()와 같음

        LOGGER.info("[getProduct] perform {} of Around Hub API.", result);


        result.orElseThrow(() -> new RuntimeException("없음"));   // <- 여기서 예외 발생

//        return quizListRepository.findByIdx(idx)
//                .orElseThrow(() -> new NoSuchElementException("해당 idx의 퀴즈가 없습니다."));

        LOGGER.info("[getProduct] Entity 객체를 DTO 객체로 변환 작업. productId : {}", result.get());


        return result.get().toDto();
    }
}
