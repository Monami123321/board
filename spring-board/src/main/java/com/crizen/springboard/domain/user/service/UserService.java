package com.crizen.springboard.domain.user.service;


import com.crizen.springboard.domain.user.dto.UserRegisterRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    // 회원가입
    public boolean register(UserRegisterRequestDTO userRegisterRequestDTO) {
        return true;
    }
    //

}
