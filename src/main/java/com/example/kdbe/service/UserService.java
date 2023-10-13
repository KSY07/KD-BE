package com.example.kdbe.service;

import com.example.kdbe.model.dto.request.UserRequestDto;
import com.example.kdbe.model.entity.User;
import jakarta.transaction.Transactional;

@Transactional
public interface UserService extends BaseService<User,UserRequestDto> {


}
