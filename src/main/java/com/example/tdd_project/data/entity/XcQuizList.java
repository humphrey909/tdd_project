package com.example.tdd_project.data.entity;

import com.example.tdd_project.data.dto.XcQuizListDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    int idx;

    String type;

    String title;

    String qText;

    String qImg;

    String solution;

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