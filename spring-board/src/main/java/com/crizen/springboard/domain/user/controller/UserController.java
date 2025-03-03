package com.crizen.springboard.domain.user.controller;


import com.crizen.springboard.domain.user.dto.UserRegisterRequestDTO;
import com.crizen.springboard.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

// 유저 관련 처리 - 회원가입
@Controller
@RequiredArgsConstructor
@RequestMapping("/register")
public class UserController {

    private final UserService userService;

    // 회원가입 폼 페이지로 이동, 모두 허용
    @GetMapping
    public String showRegisterFormPage() {
        // 회원가입 페이지 응답하기
//        model.addAttribute("userRegisterRequestDTO", new UserRegisterRequestDTO());
        return "register";
    }

    //  회원가입 요청 처리
    @PostMapping
    @ResponseBody
    public ResponseEntity<String> register(@Valid @RequestBody UserRegisterRequestDTO userRegisterRequestDTO) {
        // 회원가입 처리하기
//
//        if (userService.register(userRegisterRequestDTO)) {
//            res = new ResponseEntity<>("회원가입 성공!", HttpStatus.CREATED);
//        } else {
//            res = new ResponseEntity<>("회원가입 실패", HttpStatus.FORBIDDEN);
//        }
        userService.register(userRegisterRequestDTO);
        return ResponseEntity.created(URI.create("/login")).body("회원가입 성공!");
    }

}
