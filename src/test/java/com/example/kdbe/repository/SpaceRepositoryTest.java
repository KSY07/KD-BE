package com.example.kdbe.repository;

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
class SpaceRepositoryTest {


    @Autowired
    SpaceRepository spaceRepository;

    Space space;

    @BeforeEach
    public void setup(){
        space = Space.builder()
                .spaceId("space1")
                .name("admin")
                .build();
    }

    @Test
    @DisplayName("Repo test")
    public void testUser(){
        Space saveSpace = spaceRepository.save(space);
        Space findSpace = spaceRepository.findById(space.getId()).get();

        Assertions.assertThat(findSpace).isEqualTo(space);
    }

    @Test
    @DisplayName("CRUD 검증")
    public void testCRUD(){

        spaceRepository.save(space);

        Space findSpace = spaceRepository.findById(space.getId()).get();

        Assertions.assertThat(findSpace).isEqualTo(space);

        long count = spaceRepository.count();

        Assertions.assertThat(count).isEqualTo(1);

        spaceRepository.delete(space);

        long deleteCount = spaceRepository.count();

        Assertions.assertThat(deleteCount).isEqualTo(0);

    }
}