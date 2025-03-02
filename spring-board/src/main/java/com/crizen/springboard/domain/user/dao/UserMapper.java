package com.crizen.springboard.domain.user.dao;

import com.crizen.springboard.domain.user.dto.User;
import com.crizen.springboard.domain.user.dto.UserRegisterRequestDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    // 사용자 추가
    @Insert("INSERT INTO users(user_name, user_mail, user_password) VALUES(#{userName}, #{userMail}, #{userPassword})")
    boolean insertUser(UserRegisterRequestDTO userRegisterRequestDTO);

    // 메일로 사용자 조회
    @Select("SELECT * FROM users WHERE user_mail = #{userMame}")
    User findByEmail(String userMail);

    // 모든 사용자 조회
    @Select("SELECT * FROM users")
    List<User> findAll();


}
