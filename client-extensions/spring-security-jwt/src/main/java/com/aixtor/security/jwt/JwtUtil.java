package com.aixtor.security.jwt;

import com.aixtor.security.config.CustomUserDetails;
import com.aixtor.security.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {

    private final String SECRET = "960c58e6dbbb05fe57a94b4b28b620509e9994bcb1bab7890fcb1aba2917599cd06db733836f2cd2df7c7aa22d0f36e8387e0e0ec1c5d9350482569a8e0a02d62eff497e54aa55f3535768fe8e2f7cba6083b281c2ffd850455a337e17a55fed8ee10349845fd054d0d175077aa3b4b193eb9065ffc1e056abb40300d657708ebde0a568f6258d4b5e97c1603a3a8f601b70ec9cc78d6e4685de966a8ac353809429a3461d7f603a988f8d776d492a3ad8da55200152109e2a44cec8af9590e510c3e672ca9c1c698ac177876aab09a63a777cc1f652a9748a42a29791e2572997fa5d4eacb1ee6eb864bfe3ac62e6b4468a77132185e40da1ff8d846d55834f"; // use at least 256-bit key

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    public String generateToken(String email) {

        Map<String,Object> claims=new HashMap<>();
        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(email)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+60*60*1000))
                .and()
                .signWith(getSigningKey())
                .compact();

    }

    public String extractUsername(String token) {
        System.out.println(getClaims(token));
        return getClaims(token).getSubject();
    }

    public boolean isTokenValid(String token, CustomUserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    private Claims getClaims(String token) {
         return Jwts
                .parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }



}