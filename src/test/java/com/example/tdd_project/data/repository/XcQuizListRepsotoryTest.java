package com.example.tdd_project.data.repository;

import com.example.tdd_project.data.entity.XcQuizList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test") // 필요 시 사용
public class XcQuizListRepsotoryTest {

    @Autowired
    private XcQuizListRepository xcQuizListRepository;

    //db query 테스트
    @Test
    public void FindQuizList() {
        Optional<XcQuizList> optionalUser = Optional.ofNullable(xcQuizListRepository.findByIdx(1));
        XcQuizList quizListData = optionalUser.orElse(null);
        assertThat(quizListData).isNotNull();
        assertThat(quizListData.getIdx()).isEqualTo(1);

        System.out.println("조회된 이름: " + quizListData.getQText());
        System.out.println("조회된 이름: " + quizListData.getType());
        System.out.println("조회된 이름: " + quizListData.getIdx());
    }
}
