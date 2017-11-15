package com.personalgarage.service.security.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.personalgarage.service.main.users.interfaces.dtos.UserCredentialsDTO;
import com.personalgarage.service.security.configuration.ApplicationSecurityConfigurerParams;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final ApplicationSecurityConfigurerParams configurerParams;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, ApplicationSecurityConfigurerParams configurerParams) {
        this.authenticationManager = authenticationManager;
        this.configurerParams = configurerParams;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            UserCredentialsDTO userDTO = new ObjectMapper().readValue(request.getInputStream(), UserCredentialsDTO.class);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword(), new ArrayList<>()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String token = Jwts.builder()
                .setSubject(((org.springframework.security.core.userdetails.User) authResult.getPrincipal()).getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + configurerParams.getExpiration()))
                .signWith(SignatureAlgorithm.HS512, configurerParams.getSecret().getBytes())
                .compact();
        response.addHeader(configurerParams.getHeader(), configurerParams.getPrefix() + token);
    }
}