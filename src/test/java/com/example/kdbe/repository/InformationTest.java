package com.example.kdbe.repository;

import com.example.kdbe.model.entity.Information;
import com.example.kdbe.model.entity.Space;
import jakarta.transaction.Transactional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
class InformationTest {

    @Autowired
    InformationRepository informationRepository;

    @Autowired
    SpaceRepository spaceRepository;


    Information firstInfo;

    Space space;

    @BeforeEach
    public void setup(){

        space = Space.builder()
                .spaceId("space1")
                .name("admin")
                .build();

        spaceRepository.save(space);

        firstInfo = Information.builder()
                .title("basic info")
                .content("basic content")
                .space(space)
                .build();
    }

    @Test
    @DisplayName("Repo test")
    public void testUser(){

        Information saveInfo = informationRepository.save(firstInfo);
        Information findInfo = informationRepository.findById(saveInfo.getId()).get();

        Assertions.assertThat(saveInfo).isEqualTo(saveInfo);

    }

    @Test
    @DisplayName("CRUD 검증")
    public void testCRUD(){

        informationRepository.save(firstInfo);


        Information findInfo = informationRepository.findById(firstInfo.getId()).get();

        Assertions.assertThat(firstInfo).isEqualTo(findInfo);

        long count = informationRepository.count();

        Assertions.assertThat(count).isEqualTo(1);

        informationRepository.delete(firstInfo);

        long deleteCount = informationRepository.count();

        Assertions.assertThat(deleteCount).isEqualTo(0);


    }
}