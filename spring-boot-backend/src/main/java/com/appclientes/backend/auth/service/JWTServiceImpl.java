package com.appclientes.backend.auth.service;

import com.appclientes.backend.auth.SimpleGrantedAuthorityMixin;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

@Service
public class JWTServiceImpl implements JWTService {

    public static final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    public static final long EXPIRATION_DATE = 14000000L;

    public static final String PREFIX_TOKEN = "Bearer ";


    @Override
    public String create(Authentication auth) throws JsonProcessingException {
        String username = ((User) auth.getPrincipal()).getUsername();

        Collection<? extends GrantedAuthority> roles = auth.getAuthorities();

        Claims claims = Jwts.claims();
        claims.put("authorities", new ObjectMapper().writeValueAsString(roles));

        return Jwts.builder().setSubject(username).signWith(secretKey).setSubject(username).setClaims(claims)
                .setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_DATE)).compact();
    }

    @Override
    public boolean validate(String token) {
        try {
            getClaims(token);

            return true;

        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public Claims getClaims(String token) {

        return Jwts.parserBuilder().setSigningKey(JWTServiceImpl.secretKey).build()
                .parseClaimsJws(resolve(token)).getBody();

    }

    @Override
    public String getUsername(String token) {
        return getClaims(token).getSubject();
    }

    @Override
    public Collection<? extends GrantedAuthority> getRoles(String token) throws IOException {

        Object roles = getClaims(token).get("authorities");


        return Arrays.asList(new ObjectMapper().addMixIn(SimpleGrantedAuthority.class, SimpleGrantedAuthorityMixin.class).readValue(roles.toString().getBytes(), SimpleGrantedAuthority[].class));
    }

    @Override
    public String resolve(String token) {
        if (token != null && token.startsWith(PREFIX_TOKEN))
            return token.replace(PREFIX_TOKEN, "");
        return null;
    }
}
