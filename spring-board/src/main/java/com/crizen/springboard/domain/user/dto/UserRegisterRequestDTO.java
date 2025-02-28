package com.crizen.springboard.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRegisterRequestDTO {
    @NotNull(message = "이름은 필수입니다.")
    @Size(max = 255, message = "이름은 1자 이상 255자 이하여야 합니다.")
    private String userName;

    @NotNull(message = "이메일은 필수입니다.")
    @Size(min = 1, max = 255, message = "이메일은 1자 이상 255자 이하여야 합니다.")
    @Email(message = "유효한 이메일 형식이어야 합니다.")
    private String userMail;

    @NotNull
    @Size(min = 4, max = 255, message = "비밀번호는 4자 이상 255자 이하여야 합니다.")
    private String userPassword;
}
