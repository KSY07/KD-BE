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

@SpringBootTest
public class CredentialTest {

    @PersistenceContext
    EntityManager em;

    Credential credential;
    Credential secondCredential;

    @BeforeEach
    public void setUp(){
        credential = Credential.builder()
                .hash("adsfadsfadf")
                .salt("adfasdfasdfadsf")
                .build();

        secondCredential = Credential.builder()
                .hash("adsfsssadsfadf")
                .salt("adfasdfssssasdfadsf")
                .build();
    }

    @Test
    @Transactional
    @DisplayName("영속성 테스트")
    public void testPersist(){
        em.persist(credential);
        em.persist(secondCredential);
        List<Credential> credentials = em.createQuery("select c from Credential c", Credential.class).getResultList();
        Assertions.assertThat(credentials.size()).isEqualTo(2);
    }

    @Test
    @Transactional
    @DisplayName("엔티티 검증")
    public void testEntity(){
        em.persist(credential);
        Credential result = em.createQuery("select c from Credential c where c.hash = 'adsfadsfadf'", Credential.class).getSingleResult();
        Assertions.assertThat(credential).isEqualTo(result);
    }
}
