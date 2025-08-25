package com.ashish.APIGateway_Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    @Value("${jwt.secretKey}")
    private String jwtSecretKey;
}
