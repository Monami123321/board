package com.crizen.springboard.global.security;

import org.springframework.stereotype.Component;

@Component
public class UrlManager {

    // 시큐리티 설정에서 쓸 url 경로를 관리하도록 배열로
    public static final String[] PERMITTED_URLS = {"/login", "/register", "/posts", "/posts/*"};
    public static final String[] SIGN_IN_URLS = {"/logout", "/posts", "/posts/new", "/posts/{id}/edit", "/posts/{id}/delete", "/comments/**"};
    public static final String[] ADMIN_URLS = {};
}
