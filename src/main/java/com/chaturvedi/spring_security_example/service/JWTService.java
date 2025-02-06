package com.chaturvedi.spring_security_example.service;

import org.springframework.stereotype.Service;

@Service
public class JWTService {
    public String generateToken() {
        return "token";
    }
}
