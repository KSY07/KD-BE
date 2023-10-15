package com.example.kdbe.service.impl;

import com.example.kdbe.model.dto.request.SignInRequestDto;
import com.example.kdbe.model.dto.response.SignInResponseDto;
import com.example.kdbe.model.entity.RefreshToken;
import com.example.kdbe.model.mapStruct.StructMapper;
import com.example.kdbe.model.mapStruct.UserMapper;
import com.example.kdbe.model.dto.request.UserRequestDto;
import com.example.kdbe.model.entity.User;
import com.example.kdbe.repository.BaseRepository;
import com.example.kdbe.repository.RefreshTokenRepository;
import com.example.kdbe.repository.UserRepository;
import com.example.kdbe.service.UserService;
import com.example.kdbe.utils.AuthUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository         userRepository;
    private final UserMapper             userMapper;
    private final AuthUtils              authUtils;
    private final RefreshTokenRepository refreshTokenRepository;

    @Override
    public BaseRepository<User> getRepository() {
        return userRepository;
    }

    @Override
    public StructMapper<User,UserRequestDto> getMapper() {
        return userMapper;
    }

    @Override
    public SignInResponseDto signIn(SignInRequestDto req) {
        User u = null;
        SignInResponseDto res = new SignInResponseDto();
        try
        {
            u = userRepository.findByUserId(req.getUserId())
                    .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        }
        catch(UsernameNotFoundException e)
        {
            log.error(e.getMessage());
            return null;
        }

        boolean isValidate = authUtils.validateCredential(u.getCredential(), req.getPassword());

        if(isValidate)
        {
            //TODO: Update Security Context Holder


            //TODO: Generate AuthToken & RefToken >> Put SignInResponseDto

        }

        return null;
    }

    @Override
    public void saveRefToken(String userId, String refToken, String authToken) {
        refreshTokenRepository.save(new RefreshToken(userId, refToken, authToken));
    }

    @Override
    public void removeRefToken(String authToken) {
        refreshTokenRepository.findByAuthToken(authToken)
                .ifPresent(refreshTokenRepository::delete);
    }
}
