package com.example.tdd_project.service;


import com.example.tdd_project.data.entity.XcQuizList;
import com.example.tdd_project.data.repository.XcQuizListRepository;
import com.example.tdd_project.service.impl.XcQuizListServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.mockito.Mock;
import java.util.Optional;
import com.example.tdd_project.data.dto.XcQuizListDto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.example.tdd_project.service.XcQuizListService;
import org.mockito.InjectMocks;

@ExtendWith(MockitoExtension.class)  // ⭐ Mockito + JUnit5 연동
public class XcQuizListServiceTest {

    @Mock
    private XcQuizListRepository xcQuizListRepository;

    @InjectMocks
    private XcQuizListServiceImpl xcQuizListService;

    //db 접속 하지않고 service 단위 테스트
    @Test
    void getQuizList() {

        XcQuizList dummy = new XcQuizList();
        dummy.setIdx(1);
        dummy.setType(3);
        dummy.setTitle("초급 OX 퀴즈");
        dummy.setQText("물고기의 혀는 맛을 볼 수 없다.");
        dummy.setQImg("");
        dummy.setSolution("O,맞다,맞아,오,동그라미,네,맞는");
        dummy.setShowSolution("O");

        when(xcQuizListRepository.findByIdx(1)).thenReturn(dummy);

        // When
        XcQuizListDto result = xcQuizListService.getQuizByIdx(1);

        // Then
        assertThat(result.getQText()).isEqualTo("물고기의 혀는 맛을 볼 수 없다.");
        assertThat(result.getType()).isEqualTo(3);

        verify(xcQuizListRepository).findByIdx(1); // 호출 여부 확인
    }
}
