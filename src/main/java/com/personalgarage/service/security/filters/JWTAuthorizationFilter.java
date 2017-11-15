package com.personalgarage.service.security.filters;

import com.personalgarage.service.security.configuration.ApplicationSecurityConfigurerParams;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    private final ApplicationSecurityConfigurerParams configurerParams;

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager, ApplicationSecurityConfigurerParams configurerParams) {
        super(authenticationManager);
        this.configurerParams = configurerParams;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(configurerParams.getHeader());

        if (header == null || !header.startsWith(configurerParams.getPrefix())) {
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = null;
        try {
            authentication = getAuthentication(request);
        } catch (JwtException | IllegalArgumentException e) {
            e.printStackTrace();
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) throws JwtException, IllegalArgumentException {
        String token = request.getHeader(configurerParams.getHeader());
        if (token != null) {
            String user = Jwts.parser()
                    .setSigningKey(configurerParams.getSecret().getBytes())
                    .parseClaimsJws(token.replace(configurerParams.getPrefix(), ""))
                    .getBody()
                    .getSubject();

            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }
            return null;
        }
        return null;
    }
}