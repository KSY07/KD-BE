package com.example.kdbe.web;


import com.example.kdbe.model.dto.request.InformationRequestDto;
import com.example.kdbe.model.entity.Information;
import com.example.kdbe.service.BaseService;
import com.example.kdbe.service.InformationService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("information")
public class InformationController implements BaseController<Information, InformationRequestDto> {

    @Getter
    private final InformationService service;


}
