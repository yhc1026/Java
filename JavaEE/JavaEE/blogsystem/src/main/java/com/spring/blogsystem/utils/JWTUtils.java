package com.spring.blogsystem.utils;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JWTUtils {

    private static String SECRET_STRING="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";

    private static Key key= Keys.hmacShaKeyFor(SECRET_STRING.getBytes(StandardCharsets.UTF_8));

    public static String generateJWTToken(Map<String,Object> claims){
        String jwtToken = Jwts.builder()
                .setClaims(claims)
                .signWith(key)
                .compact();
        return jwtToken;
    }

    public static Claims parseToken(String token){
        JwtParser build = Jwts.parserBuilder().setSigningKey(key).build();
        try{
            Claims claims = build.parseClaimsJws(token).getBody();
            return claims;
        } catch (Exception e) {
            return null;
        }
    }
}
