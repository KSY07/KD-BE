package com.example.kdbe.model.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "spaces")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"spaceId","name"})
public class Space extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "space_sequence_generator")
    @TableGenerator(
            name = "space_sequence_generator",
            table = "table_sequences",
            pkColumnValue = "space_sequence" , allocationSize = 1)
    private Long id;

    private String spaceId;

    private String name;


    @OneToMany(mappedBy = "space", fetch = FetchType.LAZY)
    private List<UserSpace> userSpaces = new ArrayList<>();

    @OneToMany(mappedBy = "space", fetch = FetchType.LAZY)
    private List<Information> informationList = new ArrayList<>();

    @OneToMany(mappedBy = "space", fetch = FetchType.LAZY)
    private List<RoleSpace> roleSpaces = new ArrayList<>();

    @Builder
    public Space(Long id, String spaceId, String name){
        this.id = id;
        this.spaceId = spaceId;
        this.name = name;
    }







}
