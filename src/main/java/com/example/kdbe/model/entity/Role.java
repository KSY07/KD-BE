package com.example.kdbe.model.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Role extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "role_sequence_generator")
    @TableGenerator(
            name = "role_sequence_generator",
            table = "table_sequences",
            pkColumnValue = "role_sequence" , allocationSize = 1)
    private Long id;

    private String roleId;

    private String type;

    @OneToOne(mappedBy = "role")
    private User user;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<RoleSpace> roleSpaces = new ArrayList<>();

    @Builder
    public Role(String roleId, String type){
        this.roleId = roleId;
        this.type = type;
    }

    public void changeUser(User user){
        this.user = user;
    }
}
