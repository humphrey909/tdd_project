package com.example.tdd_project.data.entity;

import com.example.tdd_project.data.dto.UserDto;
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
@Table(name = "product")
public class User extends BaseEntity {

    @Id
    Long id;

    String name;

  /*
  @Column
  String sellerId;

  @Column
  String sellerPhoneNumber;
   */

    public UserDto toDto() {
        return UserDto.builder()
                .id(id)
                .name(name)
                .build();
    }
}