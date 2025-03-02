package com.crizen.springboard.global;

import com.crizen.springboard.domain.user.exception.UserMailDuplicatedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // resful 요청은 전역 예외 핸들러로 잡기

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<String> handleBadCredentialsException(BadCredentialsException e) {
        return new ResponseEntity<>("잘못된 아이디 또는 비밀번호입니다.", HttpStatus.UNAUTHORIZED);
    }

    // AuthenticationException 처리 (기타 인증 관련 오류)
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<String> handleAuthenticationException(AuthenticationException e) {
        return new ResponseEntity<>("인증 처리 중 오류가 발생했습니다.", HttpStatus.UNAUTHORIZED);
    }

    // 로그인 -> 그런 사람 없음
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UsernameNotFoundException e) {
        return new ResponseEntity<>("해당 유저가 존재하지 않습니다.", HttpStatus.UNAUTHORIZED);
    }

    // 회원가입 -> 이메일 중복
    @ExceptionHandler(UserMailDuplicatedException.class)
    public ResponseEntity<String> handleUserMailDuplicatedException(UserMailDuplicatedException e) {
        return new ResponseEntity<>("이메일 중복입니다.", HttpStatus.UNAUTHORIZED);
    }
}
