package com.example.tdd_project.controller;

import com.example.tdd_project.data.dto.UserDto;
import com.example.tdd_project.data.dto.XcQuizListDto;
import com.example.tdd_project.data.entity.XcQuizList;
import com.example.tdd_project.data.repository.XcQuizListRepository;
import com.example.tdd_project.service.UserService;
import com.example.tdd_project.service.XcQuizListService;
import com.example.tdd_project.service.impl.UserServiceImpl;
import com.example.tdd_project.service.impl.XcQuizListServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@SpringBootTest(properties = {"spring.profiles.active=test"})
@WebMvcTest(XcQuizListController.class)
public class XcQuizListControllerTest {

    private final Logger LOGGER = LoggerFactory.getLogger(XcQuizListServiceImpl.class);

    @Autowired private MockMvc mockMvc;

    @MockBean
    XcQuizListService xcQuizListService;

    @MockBean
    XcQuizListRepository xcQuizListRepository;

    @Test
    void getQuizList() {
        Optional<XcQuizList> optionalUser = Optional.ofNullable(xcQuizListRepository.findByIdx(1));
        XcQuizList quizListData = optionalUser.orElse(null);
        assertThat(quizListData).isNotNull();
        assertThat(quizListData.getIdx()).isEqualTo(1);

        System.out.println("조회된 이름: " + quizListData.getQText());
    }

    //db 연결없이 test : c -> s 로직
    @Test
    @DisplayName("quiz 데이터 가져오기 테스트")
    public void getQuizListNotdb() throws Exception {

        // given : Mock 객체가 특정 상황에서 해야하는 행위를 정의하는 메소드
        //여기서 미리 테스트 값을 지정 한 것.
        given(xcQuizListService.getQuizList(1))
                .willReturn(new XcQuizListDto(1, "2", "초성 퀴즈 (악기)" , "ㄱㅌ", "", "기타", "기타"));

//        doReturn(new UserDto(15872L, "pen"))
//                .when(userService).getUser(12315L);

        long qId = 1;

        // andExpect : 기대하는 값이 나왔는지 체크해볼 수 있는 메소드
        MvcResult result = mockMvc.perform(get("/api/v1/quiz-api/xcQuizList/" + qId))
                .andExpect(status().isOk())
//                .andExpect(
//                        jsonPath("$.id").exists()) // json path의 depth가 깊어지면 .을 추가하여 탐색할 수 있음 (ex :
                // $.productId.productIdName)
                .andExpect(jsonPath("$.idx").value(1))
                .andExpect(jsonPath("$.type").exists())
                .andDo(print())
                .andReturn(); // 결과 직접 반환

        // then : 상태코드 직접 확인
        int status = result.getResponse().getStatus();
//        System.out.println("응답 상태 코드: " + status);

        LOGGER.info("응답 상태 코드: " + result.getResponse());
        LOGGER.info("응답 상태 코드: " + status);

        if (status == 200) {
//            System.out.println("✅ 성공 (200 OK)");
            LOGGER.info("✅ 성공 (200 OK)");

            // verify : 해당 객체의 메소드가 실행되었는지 체크해줌
            verify(xcQuizListService).getQuizList(1);

        } else if (status == 400) {
            LOGGER.info("❌ 잘못된 요청 (400 Bad Request)");
//            System.out.println("❌ 잘못된 요청 (400 Bad Request)");
        } else {
            LOGGER.info("✅ 성공 (200 OK)");
//            System.out.println("✅ 성공 (200 OK)");
        }


    }






    //db 연결 로직 test : c -> s -> r





}
