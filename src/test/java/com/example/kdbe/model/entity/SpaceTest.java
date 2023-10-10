package com.example.kdbe.model.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class SpaceTest {

    @PersistenceContext
    EntityManager em;

    Space space;

    Space secondSpace;

    @BeforeEach
    public void setup(){
        space = Space.builder()
                .spaceId("space1")
                .name("admin")
                .build();

        secondSpace = Space.builder()
                .spaceId("space2")
                .name("commonManage")
                .build();
    }

    @Test
    @Transactional
    @DisplayName("영속성 테스트")
    public void testPersist(){
        em.persist(space);
        em.persist(secondSpace);
        List<Space> spaces = em.createQuery("select s from Space s", Space.class).getResultList();
        Assertions.assertThat(spaces.size()).isEqualTo(2);
    }

    @Test
    @Transactional
    @DisplayName("엔티티 검증")
    public void testEntity(){
        em.persist(space);
        Space result = em.createQuery("select s from Space s where s.spaceId = 'space1'",Space.class).getSingleResult();
        Assertions.assertThat(result).isEqualTo(space);
    }




}