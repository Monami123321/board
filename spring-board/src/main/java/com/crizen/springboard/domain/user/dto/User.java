package com.crizen.springboard.domain.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class User {
    private Long userId;
    private Long roleId;
    private String userName;
    private String userMail;
    private String userPassword;
    private LocalDateTime userJoinDate;
}
