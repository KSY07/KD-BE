package com.example.kdbe.model.mapStruct;

import com.example.kdbe.model.dto.request.InformationRequestDto;
import com.example.kdbe.model.dto.request.SpaceRequestDto;
import com.example.kdbe.model.entity.Information;
import com.example.kdbe.model.entity.Space;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface InformationMapper extends StructMapper<Information, InformationRequestDto>{

    @Mapping(source = "id", target = "id")
    InformationRequestDto toDto(Information information);

    @Mapping(source = "id", target = "id")
    Information toEntity(InformationRequestDto dto);
}
