package com.example.tdd_project.controller;

import com.example.tdd_project.data.dto.UserDto;
import com.example.tdd_project.service.UserService;
import com.example.tdd_project.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.google.gson.Gson;
import org.springframework.test.web.servlet.MvcResult;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.mockito.Mockito.verify;


@RunWith(SpringRunner.class)
//@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    /*
    * MockBean을 사용하여 컨트롤러만 테스트 한다.
    * UserDTO의 데이터는 db를 타지 않고 임의의 응답 데이터를 지정한다. 응답에 그 데이터가 잘 나오는제 테스트 한다.
    * */

    private final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired private MockMvc mockMvc;
    @MockBean
    UserService userService;

//    @MockBean
//    private UserServiceImpl userService;

    // http://localhost:8080/api/v1/user-api/user/{userId}
    @Test
    @DisplayName("User 데이터 가져오기 테스트")
    public void getUserTest() throws Exception {

        // given : Mock 객체가 특정 상황에서 해야하는 행위를 정의하는 메소드
        //여기서 미리 테스트 값을 지정 한 것.
        given(userService.getUser(12315L))
                .willReturn(new UserDto(15872L, "pen"));

//        doReturn(new UserDto(15872L, "pen"))
//                .when(userService).getUser(12315L);

        long userId = 12315L;

        // andExpect : 기대하는 값이 나왔는지 체크해볼 수 있는 메소드
        MvcResult result = mockMvc.perform(get("/api/v1/user-api/user/" + userId))
                .andExpect(status().isOk())
//                .andExpect(
//                        jsonPath("$.id").exists()) // json path의 depth가 깊어지면 .을 추가하여 탐색할 수 있음 (ex :
                // $.productId.productIdName)
                .andExpect(jsonPath("$.id").value(15872L))
                .andExpect(jsonPath("$.name").exists())
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
            verify(userService).getUser(12315L);

        } else if (status == 400) {
            LOGGER.info("❌ 잘못된 요청 (400 Bad Request)");
//            System.out.println("❌ 잘못된 요청 (400 Bad Request)");
        } else {
            LOGGER.info("✅ 성공 (200 OK)");
//            System.out.println("✅ 성공 (200 OK)");
        }


    }


    // http://localhost:8080/api/v1/product-api/product
    @Test
    @DisplayName("User 데이터 생성 테스트")
    public void createUserTest() throws Exception {
        // Mock 객체에서 특정 메소드가 실행되는 경우 실제 Return을 줄 수 없기 때문에 아래와 같이 가정 사항을 만들어줌
        given(userService.saveUser(15871L, "pen"))
                .willReturn(new UserDto(15871L, "pen"));

        UserDto userDto =
                UserDto.builder()
                        .id(15871L)
                        .name("pen")
                        .build();
        Gson gson = new Gson();
        String content = gson.toJson(userDto);

        // 아래 코드로 json 형태 변경 작업을 대체할 수 있음
        // String json = new ObjectMapper().writeValueAsString(productDto);

        mockMvc.perform(
                post("/api/v1/user-api/user")
                     .content(content)
                     .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").exists())
                .andDo(print());

        verify(userService).saveUser(15871L, "pen");
    }
}
