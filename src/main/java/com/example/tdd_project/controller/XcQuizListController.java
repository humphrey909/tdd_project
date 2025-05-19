package com.example.tdd_project.controller;

import com.example.tdd_project.data.dto.UserDto;
import com.example.tdd_project.data.dto.XcQuizListDto;
import com.example.tdd_project.service.XcQuizListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/quiz-api")
public class XcQuizListController {
    private final Logger LOGGER = LoggerFactory.getLogger(XcQuizListController.class);

    private final XcQuizListService xcQuizListService;


    public XcQuizListController(XcQuizListService xcQuizListService) {
        this.xcQuizListService = xcQuizListService;
    }

    // http://localhost:8080/api/v1/user-api/user/{userId}
    @GetMapping(value = "/xcQuizList/{idx}")
    public XcQuizListDto getQuizList(@PathVariable int idx) {

        long startTime = System.currentTimeMillis();
//        LOGGER.info("[getProduct] perform {} of Around Hub API.");
        LOGGER.info("[getProduct] perform {} of Around Hub API.", "getProduct");

        XcQuizListDto quizListDto = xcQuizListService.getQuizList(idx);

        LOGGER.info("[getProduct] perform {} of Around Hub API.", quizListDto.getIdx());
        LOGGER.info("[getProduct] perform {} of Around Hub API.", quizListDto.getqText());



        LOGGER.info(
                "[getProduct] Response :: productId = {}, productName = {}, Response Time = {}ms",
                quizListDto.getIdx(),
                quizListDto.getqText(),
                (System.currentTimeMillis() - startTime));
        return quizListDto;
    }
}
