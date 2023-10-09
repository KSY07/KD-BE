package com.example.kdbe.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="kdbe_user")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Column(name="user_pk")
    private long id;

    @Column(name="user_id", columnDefinition = "VARCHAR(255) NOT NULL")
    private String userId;

    @Column(name="password", columnDefinition = "VARCHAR(255) NOT NULL")
    private String password;

    @Column(name="user_email", columnDefinition = "VARCHAR(255) NOT NULL")
    private String email;

    @ManyToOne
    @JoinColumn(name="user_role", referencedColumnName = "id")
    private Role role;
}
