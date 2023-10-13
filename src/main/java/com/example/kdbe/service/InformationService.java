package com.example.kdbe.service;

import com.example.kdbe.model.dto.request.InformationRequestDto;
import com.example.kdbe.model.entity.Information;
import jakarta.transaction.Transactional;

@Transactional
public interface InformationService extends BaseService<Information, InformationRequestDto> {
}
