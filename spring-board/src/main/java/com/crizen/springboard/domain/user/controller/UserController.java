package com.crizen.springboard.domain.user.controller;


import com.crizen.springboard.domain.user.dto.UserRegisterRequestDTO;
import com.crizen.springboard.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

// 유저 관련 처리 - 회원가입
@Controller
@RequiredArgsConstructor
@RequestMapping("/register")
public class UserController {

    private final UserService userService;

    // 회원가입 폼 페이지로 이동, 모두 허용
    @GetMapping
    public String showRegisterFormPage(Model model) {
        // 회원가입 페이지 응답하기
        model.addAttribute("userRegisterRequestDTO", new UserRegisterRequestDTO());
        return "register";
    }

    //  회원가입 요청 처리
    @PostMapping
    public String register(@Valid @ModelAttribute UserRegisterRequestDTO userRegisterRequestDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        // 회원가입 처리하기
        if (!userService.register(userRegisterRequestDTO)) {
            model.addAttribute("isFailed", true);
            return "board";
        }
        return "board";
    }

}
