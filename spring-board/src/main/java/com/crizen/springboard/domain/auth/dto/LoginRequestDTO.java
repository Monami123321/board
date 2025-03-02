package com.crizen.springboard.domain.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDTO {
    @NotNull
    @Size(min = 1, max = 255, message = "메일(id)는 255자 이하여야 합니다.")
    @Email(message = "유효한 이메일 형식이 아닙니다.")
    private String userMail;

    @NotNull
    @Size(min = 4, max = 255, message = "비밀번호는 4자 이상 255자 이하입니다.")
    private String userPassword;
}
