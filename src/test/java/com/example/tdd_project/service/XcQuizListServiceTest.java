package com.example.tdd_project.service;


import com.example.tdd_project.data.entity.XcQuizList;
import com.example.tdd_project.data.repository.XcQuizListRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)  // ⭐ Mockito + JUnit5 연동
public class XcQuizListServiceTest {

    @Autowired
    private XcQuizListRepository xcQuizListRepository;

//    @Test
//    void getQuizList() {
//        Optional<XcQuizList> optionalUser = Optional.ofNullable(xcQuizListRepository.findByIdx(1));
//        XcQuizList quizListData = optionalUser.orElse(null);
//        assertThat(quizListData).isNotNull();
//        assertThat(quizListData.getIdx()).isEqualTo(1);
//
//        System.out.println("조회된 이름: " + quizListData.getQText());
//    }

}
