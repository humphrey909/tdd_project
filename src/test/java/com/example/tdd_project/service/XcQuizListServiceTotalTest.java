package com.example.tdd_project.service;

import com.example.tdd_project.data.dto.XcQuizListDto;
import com.example.tdd_project.data.repository.XcQuizListRepository;
import com.example.tdd_project.service.impl.XcQuizListServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(properties = {"spring.profiles.active=test"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)  // 실제 DB 설정 사용
public class XcQuizListServiceTotalTest {
    @Autowired
    private XcQuizListRepository xcQuizListRepository;

    @Autowired
    private XcQuizListServiceImpl xcQuizListService;



    @Test
    public void getQuizOneTest(){

        // when
        XcQuizListDto quiz = xcQuizListService.getQuizByIdx(1);

        // then
        XcQuizListDto found = xcQuizListRepository.findByIdx(quiz.getIdx()).toDto();
        assertThat(found.getTitle()).isNotNull();


//        xcQuizListService.getQuizByIdx(1);
//
//        // then
//        assertThrows(IllegalStateException.class, () -> xcQuizListService.getQuizByIdx(1));
    }


}
