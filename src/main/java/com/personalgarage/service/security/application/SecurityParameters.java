package com.personalgarage.service.security.application;

public interface SecurityParameters {
    String SECRET = "-rPVH=A7=,.s@;2'{)J8";
    long EXPIRATION_TIME = 864_000_000; // 10 days
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
}