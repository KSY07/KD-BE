package com.example.kdbe.web;


import com.example.kdbe.model.dto.request.SpaceRequestDto;
import com.example.kdbe.model.entity.Space;
import com.example.kdbe.service.SpaceService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("space")
public class SpaceController implements BaseController<Space, SpaceRequestDto> {

    @Getter
    private final SpaceService service;
}
