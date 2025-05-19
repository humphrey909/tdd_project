package com.example.tdd_project.data.repository;

import com.example.tdd_project.data.dto.XcQuizListDto;
import com.example.tdd_project.data.entity.XcQuizList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface XcQuizListRepository extends JpaRepository<XcQuizList, String> {


    XcQuizList save(XcQuizListDto user);
    XcQuizList findByIdx(int idx);
}