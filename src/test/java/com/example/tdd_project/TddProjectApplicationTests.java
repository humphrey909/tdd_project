package com.example.tdd_project;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Matchers.any;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
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


    @Test
    void contextLoads() {}
}
