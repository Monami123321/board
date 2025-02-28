package com.crizen.springboard.domain.auth.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {

    @GetMapping("/login")
    public String showLoginPage() {
        // 로그인 페이지로 이동, 모두 허용
        return "loginForm";
    }

    @GetMapping("/logout")
    public String logout() {

        // 로그아웃 처리하고 홈으로 이동
        return "home";
    }

    @PostMapping("/login")
    public String login() {
        // 로그인 로직 처리

        return "home";
    }
}
