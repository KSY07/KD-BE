package com.example.kdbe.utils;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class AuthUtils {

    @Value("${auth.secretKey}")
    private String SECRET_KEY;

}

