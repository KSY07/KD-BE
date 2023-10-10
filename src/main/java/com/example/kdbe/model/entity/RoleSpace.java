package com.example.kdbe.model.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoleSpace extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "role_space_sequence_generator")
    @TableGenerator(
            name = "role_space_sequence_generator",
            table = "table_sequences",
            pkColumnValue = "role_space_sequence" , allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "space_id")
    private Space space;


    @Builder
    public RoleSpace(Role role, Space space){
        if(role != null){
            changeRole(role);
        }
        if(space != null){
            changeSpace(space);
        }
    }

    public void changeRole(Role role){
        this.role = role;

    }

    public void changeSpace(Space space){
        this.space = space;
        space.getRoleSpaces().add(this);
    }

}
