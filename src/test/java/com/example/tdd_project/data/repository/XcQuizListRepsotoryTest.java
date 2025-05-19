package com.example.tdd_project.data.repository;

import com.example.tdd_project.data.dto.XcQuizListDto;
import com.example.tdd_project.data.entity.XcQuizList;
import com.example.tdd_project.service.XcQuizListService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest(properties = {"spring.profiles.active=test"})
@DataJpaTest
public class XcQuizListRepsotoryTest {

//    @Autowired
//    private XcQuizListRepository xcQuizListRepository;


//    @Test
//    void testSaveAndFindByIdx() {
////        XcQuizList quiz = new XcQuizList();
////        quiz.setIdx(1);
////        quiz.setName("Test Quiz");
////        repository.save(quiz);
//
////        XcQuizList result = repository.findByIdx(1);
//
////        assertNotNull(result);
////        assertEquals("Test Quiz", result);
//
//
//        Optional<XcQuizList> optionalUser = Optional.ofNullable(xcQuizListRepository.findByIdx(1));
//        XcQuizList quizListData = optionalUser.orElse(null);
//        assertThat(quizListData).isNotNull();
//        assertThat(quizListData.getIdx()).isEqualTo(1);
//
//        System.out.println("조회된 이름: " + quizListData.getQText());
//    }




    @MockBean
    private XcQuizListRepository xcQuizListRepository;  // ⭐ Repository를 Mock으로

//    @Autowired
//    private XcQuizListService xcQuizListService;       // ⭐ 실제 Service Bean
//
//    @Test
//    void getQuizList() {
//        // ⭐ given : repository에서 특정 값 리턴하도록 지정
//        XcQuizList mockData = new XcQuizList();
//        mockData.setIdx(1);
//        mockData.setQText("테스트 문제");
//
//        given(xcQuizListRepository.findByIdx(1)).willReturn(mockData);
//
//        // ⭐ when : 서비스 또는 컨트롤러에서 호출
//        XcQuizListDto result = xcQuizListService.getQuizList(1);
//
//        // ⭐ then : 검증
//        assertThat(result).isNotNull();
//        assertThat(result.getIdx()).isEqualTo(1);
//        assertThat(result.getqText()).isEqualTo("ㄱㅌ");
//
//        System.out.println("조회된 이름: " + result.getqText());
//    }


//
//    @Autowired
//    private XcQuizListRepository xcQuizListRepository;

//    @org.junit.jupiter.api.Test
//    void getQuizList() {
//        Optional<XcQuizList> optionalUser = Optional.ofNullable(xcQuizListRepository.findByIdx(1));
//        XcQuizList quizListData = optionalUser.orElse(null);
//        assertThat(quizListData).isNotNull();
//        assertThat(quizListData.getIdx()).isEqualTo(1);
//
//        System.out.println("조회된 이름: " + quizListData.getQText());
//    }
}
