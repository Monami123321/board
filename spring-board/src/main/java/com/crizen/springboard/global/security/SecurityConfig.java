package com.crizen.springboard.global.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


// @EnableWebSecurity에 @Configuration이 포함되어 있다고 하는데, 안 넣으면 컴파일 오류남
@EnableWebSecurity(debug = true)
@EnableMethodSecurity // 메서드 수준에서 컨트롤하려면 해당 어노테이션 필요
@Configuration
public class SecurityConfig {

    // 암호 단방향 해싱용
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 시큐리티 설정을 직접 등록하는 6.xx 부터는 인증 처리하는 매니저를 빈으로 직접 등록해야 함
    // AuthenticationManager 가져오기 -> 공식문서에 구체적인 방법이 나와있지 않음
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }


    // 필터체인 등록
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .formLogin(AbstractHttpConfigurer::disable)
                // csrf 구성 방식이 메서드 체인에서 람다식으로 변경 6.x 부터 (csrf->csrf.disable())
                // 앞으로도 하나의 요소에 대한 설정은 하나의 메서드에서 모두 처리하도록 설계 예정이라고 함.
                .csrf(AbstractHttpConfigurer::disable)
                // cors 허용
                .cors(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                // 로그아웃하면 필터체인에서 /login으로 보내버리는 문제 있음 -> 꺼버리기
                .logout(AbstractHttpConfigurer::disable)
                // URL 권한설정 - 다 풀고 메서드에서 하기로
                .authorizeHttpRequests(auth -> auth.requestMatchers("/**").permitAll())
                .build();
    }


}
