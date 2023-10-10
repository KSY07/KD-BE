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
class InformationTest {

    @PersistenceContext
    EntityManager em;

    Information information;

    Space space;

    @BeforeEach
    public void setup(){

        space = Space.builder()
                .spaceId("space1")
                .name("admin")
                .build();

        information = Information.builder()
                .title("first title")
                .content("nothing")
                .space(space)
                .build();
    }

    @Test
    @Transactional
    @DisplayName("영속성 테스트")
    public void testPersist(){
        em.persist(space);
        em.persist(information);
        List<Information> result = em.createQuery("select I from Information I", Information.class).getResultList();
        Assertions.assertThat(result.size()).isEqualTo(1);
    }

    @Test
    @Transactional
    @DisplayName("엔티티 검증")
    public void testEntity(){
        em.persist(space);
        em.persist(information);
        Information result = em.createQuery("select I from Information I where I.title = 'first title'", Information.class).getSingleResult();
        Assertions.assertThat(result).isEqualTo(information);
    }

    @Test
    @Transactional
    @DisplayName("양방향 관계 검증")
    public void testTwoWayRelationShip(){
        em.persist(information);
        em.persist(space);
        Space space = em.createQuery("select S from Space S where S.spaceId='space1'", Space.class).getSingleResult();
        Assertions.assertThat(space.getInformationList().get(0)).isEqualTo(information);
    }
}