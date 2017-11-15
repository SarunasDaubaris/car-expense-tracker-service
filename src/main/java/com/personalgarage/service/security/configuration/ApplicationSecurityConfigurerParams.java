package com.personalgarage.service.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationSecurityConfigurerParams {

    private final String secret;
    private final Long expiration;
    private final String prefix;
    private final String header;

    @Autowired
    public ApplicationSecurityConfigurerParams(@Value("${app.jwt.token.secret}") String secret,
                                               @Value("${app.jwt.token.expiration}") Long expiration,
                                               @Value("${app.jwt.token.prefix}") String prefix,
                                               @Value("${app.jwt.token.header}") String header) {
        this.secret = secret;
        this.expiration = expiration;
        this.prefix = prefix;
        this.header = header;
    }

    public String getSecret() {
        return secret;
    }

    public Long getExpiration() {
        return expiration;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getHeader() {
        return header;
    }
}