package com.example.tdd_project.data.dto;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@RedisHash(value = "xc_quiz_list", timeToLive = 60)
public class XcQuizListDto {
    private int idx;
    String type;

    String title;

    String qText;

    String qImg;

    String solution;

    String showSolution;

    // getter
    public int getIdx() {
        return idx;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getqText() {
        return qText;
    }

    public String getqImg() {
        return qImg;
    }

    public String getSolution() {
        return solution;
    }

    public String getShowSolution() {
        return showSolution;
    }

//    // @Size(min = 8, max = 8) // abcdefg
//    @NotNull private String productId;
//
//    @NotNull @Id private String productName;
//
//    @NotNull
//    @Min(value = 500)
//    @Max(value = 3000000)
//    private int productPrice;
//
//    @NotNull
//    @Min(value = 0)
//    @Max(value = 9999)
//    private int productStock;

    public XcQuizListDto toEntity() {
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
