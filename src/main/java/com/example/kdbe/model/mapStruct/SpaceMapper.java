package com.example.kdbe.model.mapStruct;

import com.example.kdbe.model.dto.request.SpaceRequestDto;
import com.example.kdbe.model.dto.request.UserRequestDto;
import com.example.kdbe.model.entity.Space;
import com.example.kdbe.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SpaceMapper extends StructMapper<Space,SpaceRequestDto> {

    @Mapping(source = "id", target = "id")
    SpaceRequestDto toDto(Space space);

    @Mapping(source = "id", target = "id")
    Space toEntity(SpaceRequestDto dto);
}
