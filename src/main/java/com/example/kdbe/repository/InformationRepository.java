package com.example.kdbe.repository;

import com.example.kdbe.model.entity.Information;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository extends JpaRepository<Information,Long> {
}
