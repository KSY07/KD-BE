package com.example.kdbe.model.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Information extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "information_sequence_generator")
    @TableGenerator(
            name = "information_sequence_generator",
            table = "table_sequences",
            pkColumnValue = "information_sequence" , allocationSize = 1)
    private Long id;

    private String title;

    private String content;

    @ManyToOne
    @JoinColumn(name = "space_id")
    private Space space;

    @Builder
    private Information(Long id, String title, String content, Space space){
        this.id = id;
        this.title = title;
        this.content = content;
        if(space != null){
            changeSpace(space);
        }
    }

    public void changeSpace(Space space){
        this.space = space;
        space.getInformationList().add(this);
    }



}
