package com.example.kdbe.repository;

import com.example.kdbe.model.entity.User;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Transactional
class UserSpaceRepositoryTest {


    @Autowired
    UserSpaceRepository userSpaceRepository;

    @BeforeEach
    public void setup(){

    }

    @Test
    @DisplayName("Repo test")
    public void testUser(){

    }

    @Test
    @DisplayName("CRUD 검증")
    public void testCRUD(){

    }
}