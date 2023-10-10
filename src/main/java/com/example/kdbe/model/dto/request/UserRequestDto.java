package com.example.kdbe.model.dto.request;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserRequestDto {

    private Long id;

    private String userId;

    private String name;

    private String email;
}
