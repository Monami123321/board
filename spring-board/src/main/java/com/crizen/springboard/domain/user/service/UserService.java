package com.crizen.springboard.domain.user.service;


import com.crizen.springboard.domain.user.dao.UserMapper;
import com.crizen.springboard.domain.user.dto.User;
import com.crizen.springboard.domain.user.dto.UserRegisterRequestDTO;
import com.crizen.springboard.domain.user.exception.UserMailDuplicatedException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    // 데이터 계층
    private final UserMapper userMapper;
    // 비밀번호 해싱
    private final PasswordEncoder passwordEncoder;

    // 회원가입
    public boolean register(UserRegisterRequestDTO userRegisterRequestDTO) {
        String mail = userRegisterRequestDTO.getUserMail();
        // 메일 unique
        if (userMapper.findByEmail(mail) != null) {
            throw new UserMailDuplicatedException();
        }

        // 비밀번호 해싱
        String pwd = passwordEncoder.encode(userRegisterRequestDTO.getUserPassword());
        userRegisterRequestDTO.setUserPassword(pwd);

        return userMapper.insertUser(userRegisterRequestDTO);
    }

    // 모든 회원 조회하기
    public List<User> getAllUsers() {
        return userMapper.findAll();
    }

}
