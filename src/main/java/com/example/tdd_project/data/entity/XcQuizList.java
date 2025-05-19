package com.example.tdd_project.data.entity;

import com.example.tdd_project.data.dto.XcQuizListDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "xc_quiz_list")
public class XcQuizList extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idx;

    @Column(nullable = false, length = 11)
    Integer type;

    @Column(nullable = false, length = 100)
    String title;

    @Column(nullable = false, length = 100)
    String qText;

    @Column(nullable = false, length = 1000)
    String qImg;

    @Column(nullable = false, length = 1000)
    String solution;

    @Column(nullable = false, length = 1000)
    String showSolution;

  /*
  @Column
  String sellerId;

  @Column
  String sellerPhoneNumber;
   */

    public XcQuizListDto toDto() {
        return XcQuizListDto.builder()
                .idx(idx)
                .type(type)
                .title(title)
                .qText(qText)
                .qImg(qImg)
                .solution(solution)
                .showSolution(showSolution)
                .build();
    }
}