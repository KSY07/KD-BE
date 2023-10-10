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
class UserSpaceTest {

    @PersistenceContext
    EntityManager em;

    UserSpace userSpace;
    UserSpace secondUserSpace;

    Space space;
    User user;
    @BeforeEach
    public void setup(){

        space = Space.builder()
                .spaceId("space1")
                .name("admin")
                .build();

        user = User.builder()
                .userId("test1234")
                .name("kim")
                .email("ssss@naver.com")
                .build();

        userSpace = UserSpace.builder()
                .space(space)
                .user(user)
                .build();

        secondUserSpace = UserSpace.builder()
                .space(space)
                .build();
    }

    @Test
    @Transactional
    @DisplayName("영속성 테스트")
    public void testPersist(){
        em.persist(space);
        em.persist(user);
        em.persist(userSpace);
        em.persist(secondUserSpace);

        List<UserSpace> result = em.createQuery("select us from UserSpace us", UserSpace.class).getResultList();
        Assertions.assertThat(result.size()).isEqualTo(2);
    }

    @Test
    @Transactional
    @DisplayName("엔티티 검증")
    public void testEntity(){
        em.persist(space);
        em.persist(user);
        em.persist(userSpace);

        UserSpace result = em.createQuery("select us from UserSpace us where us.space.spaceId = 'space1' ", UserSpace.class).getSingleResult();
        Assertions.assertThat(result).isEqualTo(userSpace);

    }

    @Test
    @Transactional
    @DisplayName("양방향 관계 검증")
    public void testTwoWayRelationShip(){
        em.persist(space);
        em.persist(user);
        em.persist(userSpace);

        User result = em.createQuery("select u from User u where u.userId = 'test1234'", User.class).getSingleResult();
        Assertions.assertThat(result.getUserSpaces().size()).isEqualTo(1);
    }

}