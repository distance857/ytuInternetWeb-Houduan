package com.example.ytuinternetwebhouduan.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    private static final String SECRET_KEY = "lixang"; // 密钥，自定义
    private static final long EXPIRATION_TIME = 86400000L; // 过期时间为一天

    // 生成JWT token
    public String generateToken(String username, String password) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(username)
                .claim("password", password)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // 解析JWT token
    public String getUsernameFromToken(String token) {
        JwtParser parser = Jwts.parser().setSigningKey(SECRET_KEY);
        Claims claims = parser.parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public String getPasswordFromToken(String token) {
        JwtParser parser = Jwts.parser().setSigningKey(SECRET_KEY);
        Claims claims = parser.parseClaimsJws(token).getBody();
        return (String) claims.get("password");
    }
}
