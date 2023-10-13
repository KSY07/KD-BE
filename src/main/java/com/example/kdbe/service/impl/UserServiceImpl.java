package com.example.kdbe.service.impl;

import com.example.kdbe.model.mapStruct.StructMapper;
import com.example.kdbe.model.mapStruct.UserMapper;
import com.example.kdbe.model.dto.request.UserRequestDto;
import com.example.kdbe.model.entity.User;
import com.example.kdbe.repository.BaseRepository;
import com.example.kdbe.repository.UserRepository;
import com.example.kdbe.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public BaseRepository<User> getRepository() {
        return userRepository;
    }

    @Override
    public StructMapper<User,UserRequestDto> getMapper() {
        return userMapper;
    }
}
