package com.example.kdbe.model.mapStruct;

import com.example.kdbe.model.dto.request.UserRequestDto;
import com.example.kdbe.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper extends StructMapper<User,UserRequestDto>{

    UserRequestDto toDto(User user);

    @Mapping(source = "id", target = "id")
    User toEntity(UserRequestDto dto);
}
