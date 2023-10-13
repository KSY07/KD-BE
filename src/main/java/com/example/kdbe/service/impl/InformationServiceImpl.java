package com.example.kdbe.service.impl;


import com.example.kdbe.model.dto.request.InformationRequestDto;
import com.example.kdbe.model.entity.Information;
import com.example.kdbe.model.mapStruct.InformationMapper;
import com.example.kdbe.model.mapStruct.StructMapper;
import com.example.kdbe.repository.BaseRepository;
import com.example.kdbe.repository.InformationRepository;
import com.example.kdbe.service.InformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InformationServiceImpl implements InformationService {

    private final InformationRepository informationRepository;

    private final InformationMapper informationMapper;

    @Override
    public BaseRepository<Information> getRepository() {
        return informationRepository;
    }

    @Override
    public StructMapper<Information, InformationRequestDto> getMapper() {
        return informationMapper;
    }
}
