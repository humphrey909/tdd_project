package com.example.tdd_project;

import com.example.tdd_project.data.dto.XcQuizListDto;
import com.example.tdd_project.data.entity.XcQuizList;
import com.example.tdd_project.data.repository.XcQuizListRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.Matchers.any;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(properties = {"spring.profiles.active=test"})   // ✅ test profile 강제 적용
//@SpringBootTest
class TddProjectApplicationTests {

//	@Mock
//	UserRepository userRepository;
//
//	@InjectMocks
//	UserService userService;
//
//    @Test
//    public void registerUser_success() {
//        // given
//        UserRepository userRepository = mock(UserRepository.class);
//        UserService userService = new UserService(userRepository);
//
//        User user = new User(1L, "야");
//        when(userRepository.save(any(User.class))).thenReturn(user);
//
//        // when
//        User result = userService.registerUser(1L, "야");
//
//        // then
//        assertThat(result).isNotNull();
//        assertThat(result.getName()).isEqualTo("야");
//        verify(userRepository).save(any(User.class));
//    }


//    @Autowired
//    private UserRepository userRepository;


    @Autowired
    private XcQuizListRepository xcQuizListRepository;

    @Test
    void contextLoads() {
        // ✅ Spring Context가 정상적으로 떴는지 확인
        assertThat(xcQuizListRepository).isNotNull();
    }
}
