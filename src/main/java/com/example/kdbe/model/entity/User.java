package com.example.kdbe.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.security.Permission;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "userId", "name", "email"})
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,
                    generator = "user_sequence_generator")
    @TableGenerator(
            name = "user_sequence_generator",
            table = "table_sequences",
            pkColumnValue = "user_sequence" , allocationSize = 1)
    private Long id;

    private String userId;

    private String name;

    private String email;

    @OneToOne(fetch = FetchType.LAZY,  orphanRemoval = true)
    @JoinColumn(name="id")
    private Credential credential;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name="id")
    private Role role;

    @Builder
    public User(String userId, String name, String email, Credential credential, Role role){
        this.userId = userId;
        this.name = name;
        this.email = email;
        if(credential != null){
            changeCredential(credential);
        }
        if(role != null){
            changeRole(role);
        }
    }

    public void changeCredential(Credential credential){
        this.credential = credential;
        credential.changeUser(this);
    }

    public void changeRole(Role role){
        this.role = role;
        role.changeUser(this);
    }


}
