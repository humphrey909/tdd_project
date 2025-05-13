package com.example.tdd_project.service;

import com.example.tdd_project.data.dto.UserDto;
import com.example.tdd_project.data.entity.User;
import com.example.tdd_project.data.handler.impl.UserDataHandlerImpl;
import com.example.tdd_project.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.verify;


//@SpringBootTest(classes = {UserDataHandlerImpl.class, UserServiceImpl.class})
@RunWith(SpringRunner.class)
@Import({UserDataHandlerImpl.class, UserServiceImpl.class})
public class UserServiceTest {

    @MockBean
    UserDataHandlerImpl userDataHandler;

    @Autowired
    UserServiceImpl userService;

    @Test
    public void getUserTest() {
        // given
        Mockito.when(userDataHandler.getUserEntity(123L))
                .thenReturn(new User(123L, "pen"));

        UserDto userDto = userService.getUser(123L);

        Assertions.assertEquals(userDto.getId(), 123L);
        Assertions.assertEquals(userDto.getName(), "pen");

        verify(userDataHandler).getUserEntity(123L);
    }

    @Test
    public void saveUserTest() {
        // given
        Mockito.when(userDataHandler.saveUserEntity(123L, "pen"))
                .thenReturn(new User(123L, "pen"));

        UserDto productDto = userService.saveUser(123L, "pen");

        Assertions.assertEquals(productDto.getId(), 123L);
        Assertions.assertEquals(productDto.getName(), "pen");

        verify(userDataHandler).saveUserEntity(123L, "pen");
    }
}
