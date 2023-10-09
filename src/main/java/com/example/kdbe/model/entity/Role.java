package com.example.kdbe.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="KDBE_ROLE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="role_name", columnDefinition = "VARCHAR(50) NOT NULL")
    private String roleNm;

    /**
     * Other Attributes Here
     */
}
