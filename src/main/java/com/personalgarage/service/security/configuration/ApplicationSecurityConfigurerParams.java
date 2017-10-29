package com.personalgarage.service.security.configuration;

// Keep params public for demonstration purposes only
public final class ApplicationSecurityConfigurerParams {

    private ApplicationSecurityConfigurerParams() {
    }

    public static final String SECRET = "-rPVH=A7=,.s@;2'{)J8";
    public static final Long EXPIRATION_TIME = 864_000_000L; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}