package com.crizen.springboard.domain.user.exception;

// 회원가입시 이메일 중복 -> 예외 던지기
public class UserMailDuplicatedException extends RuntimeException {

    public UserMailDuplicatedException() {
        super("이미 사용 중인 이메일입니다.");
    }
}
