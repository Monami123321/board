package com.crizen.springboard.domain.user.controller;


import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// 유저 관련 처리 - 회원가입
@Controller
@RequiredArgsConstructor
@RequestMapping("/register")
public class UserController {

    // 회원가입 폼 페이지로 이동, 모두 허용
    @GetMapping
    public String showRegisterFormPage() {
        // 회원가입 페이지 응답하기

        return "register";
    }

    //  회원가입 요청 처리
    @PostMapping
    public String register(User user) {
        // 회원가입 처리하기


        return "aa";
    }

}
