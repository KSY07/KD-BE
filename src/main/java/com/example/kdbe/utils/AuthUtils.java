package com.example.kdbe.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AuthUtils {

    @Value("${auth.secretKey}")
    private String SECRET_KEY;


}
