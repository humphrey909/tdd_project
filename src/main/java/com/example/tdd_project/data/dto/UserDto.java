package com.example.tdd_project.data.dto;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@RedisHash(value = "user", timeToLive = 60)
public class UserDto {
    private Long id;
    private String name;

    // getter
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public UserDto toEntity() {
        return UserDto.builder()
                .id(id)
                .name(name)
                .build();
    }
}
