package com.example.kdbe.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"hash","salt"})
public class Credential extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "credential_sequence_generator")
    @TableGenerator(
            name = "credential_sequence_generator",
            table = "table_sequences",
            pkColumnValue = "credential_sequence" , allocationSize = 1)
    private Long id;

    private String hash;

    private String salt;

    @OneToOne(mappedBy = "credential")
    private User user;

    @Builder
    public Credential(String hash, String salt){
        this.hash = hash;
        this.salt = salt;
    }

    public void changeUser(User user){
        this.user = user;
    }





}
