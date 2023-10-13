package com.example.kdbe.service.impl;

import com.example.kdbe.model.dto.request.SpaceRequestDto;
import com.example.kdbe.model.entity.Space;
import com.example.kdbe.model.mapStruct.SpaceMapper;
import com.example.kdbe.model.mapStruct.StructMapper;
import com.example.kdbe.repository.BaseRepository;
import com.example.kdbe.repository.SpaceRepository;
import com.example.kdbe.service.SpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpaceServiceImpl implements SpaceService {

    private final SpaceRepository spaceRepository;

    private final SpaceMapper spaceMapper;
    @Override
    public BaseRepository<Space> getRepository() { return spaceRepository; }

    @Override
    public StructMapper<Space, SpaceRequestDto> getMapper() {
        return spaceMapper;
    }
}
