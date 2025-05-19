package com.example.tdd_project.controller;

import com.example.tdd_project.service.XcQuizListService;
import com.example.tdd_project.service.impl.XcQuizListServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

@SpringBootTest(properties = {"spring.profiles.active=test"})
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class XcQuizListControllerTest {

    private final Logger LOGGER = LoggerFactory.getLogger(XcQuizListServiceImpl.class);

    @Autowired private MockMvc mockMvc;

    //db 연결없이 test : c -> s 로직
    //통합테스트
    @Test
    @DisplayName("quiz 데이터 가져오기 테스트")
    public void getQuizListOfOne() throws Exception {

        int qId = 2;

        // andExpect : 기대하는 값이 나왔는지 체크해볼 수 있는 메소드
        MvcResult result = mockMvc.perform(get("/api/v1/quiz-api/xcQuizList/" + qId))
                .andExpect(status().isOk())
//                .andExpect(
//                        jsonPath("$.id").exists()) // json path의 depth가 깊어지면 .을 추가하여 탐색할 수 있음 (ex :
                // $.productId.productIdName)
                .andExpect(jsonPath("$.idx").value(qId))
                .andExpect(jsonPath("$.type").exists())
                .andDo(print())
                .andReturn(); // 결과 직접 반환

        // then : 상태코드 직접 확인
        int status = result.getResponse().getStatus();
//        System.out.println("응답 상태 코드: " + status);

        LOGGER.info("응답 상태 코드: " + result.getResponse());
//        LOGGER.info("응답 상태 코드: " + result.getResponse().get);
        LOGGER.info("응답 상태 코드: " + status);

        if (status == 200) {
//            System.out.println("✅ 성공 (200 OK)");
            LOGGER.info("✅ 성공 (200 OK)");

        } else if (status == 400) {
            LOGGER.info("❌ 잘못된 요청 (400 Bad Request)");
//            System.out.println("❌ 잘못된 요청 (400 Bad Request)");
        } else {
            LOGGER.info("✅ 성공 (200 OK)");
//            System.out.println("✅ 성공 (200 OK)");
        }
    }

    //db 연결 로직 test : c -> s -> r
    @Test
    void TotalTest() throws Exception {
        int qId = 4;

        mockMvc.perform(get("/api/v1/quiz-api/xcQuizList/" + qId))
                .andExpect(status().isOk());
    }
}
