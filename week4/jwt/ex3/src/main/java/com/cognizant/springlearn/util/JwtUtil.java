package com.cognizant.springlearn.util;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtil.class);
    private static final String SECRET_KEY = "secretkey";
    private static final long EXPIRATION_TIME = 20 * 60 * 1000;

    public String generateToken(String username) {
        LOGGER.info("START");
        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
        LOGGER.debug("Generated token for user: {}", username);
        LOGGER.info("END");
        return token;
    }
}
