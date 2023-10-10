package com.example.kdbe.Repository;

import com.example.kdbe.model.entity.Information;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository extends JpaRepository<Information,Long> {
}
