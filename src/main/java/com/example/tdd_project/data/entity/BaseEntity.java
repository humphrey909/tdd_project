package com.example.tdd_project.data.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;


@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    /*
    @CreatedBy
    @Column(updatable = false)
    private String createdBy;
    */
    @CreatedDate
//    @Column(updatable = false)
    @Column(name = "create_st")
    private LocalDateTime createSt;

    /*
    @LastModifiedBy
    private String updatedBy;
    */
    @LastModifiedDate
    private LocalDateTime updateSt;
    /*
      @LastModifiedBy
      private String updatedBy;
    */
    @LastModifiedDate
    private LocalDateTime deleteSt;


}