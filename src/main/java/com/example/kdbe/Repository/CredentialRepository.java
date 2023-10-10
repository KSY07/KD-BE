package com.example.kdbe.Repository;

import com.example.kdbe.model.entity.Credential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialRepository extends JpaRepository<Credential,Long> {
}
