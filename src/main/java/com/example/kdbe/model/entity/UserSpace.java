package com.example.kdbe.model.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserSpace extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "user_space_sequence_generator")
    @TableGenerator(
            name = "user_space_sequence_generator",
            table = "table_sequences",
            pkColumnValue = "user_space_sequence" , allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "space_id")
    private Space space;

    @Builder
    public UserSpace(User user, Space space){
        if(user != null){
            changeUser(user);
        }
        if(space != null){
            changeSpace(space);
        }
    }

    public void changeUser(User user){
        this.user = user;
        user.getUserSpaces().add(this);
    }

    public void changeSpace(Space space){
        this.space = space;
        space.getUserSpaces().add(this);
    }



}
