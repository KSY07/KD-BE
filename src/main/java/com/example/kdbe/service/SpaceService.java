package com.example.kdbe.service;

import com.example.kdbe.model.dto.request.SpaceRequestDto;
import com.example.kdbe.model.entity.Space;
import jakarta.transaction.Transactional;

@Transactional
public interface SpaceService extends BaseService<Space, SpaceRequestDto> {
}
