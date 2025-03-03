package com.crizen.springboard.domain.auth.controller;


import com.crizen.springboard.domain.auth.dto.CustomUser;
import com.crizen.springboard.domain.auth.dto.LoginRequestDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class AuthController {
    // 세션 직접 컨트롤 해야 할 때 - 공식문서
    private final SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
    private final SecurityContextHolderStrategy securityContextHolderStrategy = SecurityContextHolder.getContextHolderStrategy();

    private final SecurityContextRepository securityContextRepository =
            new HttpSessionSecurityContextRepository();

    private final AuthenticationManager authenticationManager;

    @GetMapping("/login")
    public String showLoginPage(@AuthenticationPrincipal CustomUser user) {
        // 로그인 페이지로 이동, 모두 허용
        // 이미 로그인 상태면 첫 화면으로 리다이렉트
        return user == null ? "login" : "redirect:/";
    }

    @GetMapping("/logout")
    @PreAuthorize("hasRole('USER')") // ROLE_USER 하니까 오류남, 스프링 시큐리티가 기본적으로 prefix 붙인다고 함
    public String logout(Authentication authentication, HttpServletRequest req, HttpServletResponse res) {
        this.logoutHandler.logout(req, res, authentication);
        // 로그아웃 -> 컨트롤러에서 바로 처리
        // 1. 세션 무효화 - 스프링 시큐리티 컨텍스트 홀더에 등록됐던 세션을 없앰
//        SecurityContextHolder.clearContext();
        // 2. 로그아웃 처리하고 홈으로 이동, 로그인 유저만 허용 ROLE_USER
        return "redirect:/";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequestDTO loginRequestDTO,
                                        HttpServletRequest req, HttpServletResponse res) {
        // 로그인 로직 처리 - 세션 직접 컨트롤 필요 -> 공식문서 그대로 JSSESSION:
        String mail = loginRequestDTO.getUserMail();
        String pwd = loginRequestDTO.getUserPassword();

        UsernamePasswordAuthenticationToken token = UsernamePasswordAuthenticationToken.unauthenticated(mail, pwd);
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContext context = securityContextHolderStrategy.createEmptyContext();
        context.setAuthentication(authentication);
        securityContextHolderStrategy.setContext(context);
        securityContextRepository.saveContext(context, req, res);
        return new ResponseEntity<>("로그인 완료", HttpStatus.OK);
    }
}
