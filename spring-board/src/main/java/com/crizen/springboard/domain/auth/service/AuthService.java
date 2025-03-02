package com.crizen.springboard.domain.auth.service;

import com.crizen.springboard.domain.auth.dto.CustomUser;
import com.crizen.springboard.domain.user.dao.UserMapper;
import com.crizen.springboard.domain.user.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {
    // 스프링 시큐리티에서 제공하는 인터페이스를 통해 로그인 서비스 구현
    private final UserMapper userMapper;
//    private final AuthenticationManager authenticationManager; // 인증을 실제로 처리하는 매니저


    @Override
    public UserDetails loadUserByUsername(String userMail) throws UsernameNotFoundException {
        // 이 메서드를 통해서 AuthenticationManager에게 유저 정보를 전달하고 검증함.
        // AuthenticationManager는 실패할 경우 예외를 던지고 성공하면 Authentication 객체 반환

        // DB 조회
        User user = userMapper.findByEmail(userMail);
        if (user == null) {
            throw new UsernameNotFoundException("해당 이메일로 등록 된 유저가 없습니다.");
        }
        // 유저 권한 부여 리스트 - 관리자면 추가 권한 부여
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (user.getRoleId() == 1) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        // AuthenticationManager가 인증 처리를 위해 이 메서드를 호출, userDetail 생성하여 반환 -> 커스텀해서 이메일도 추가하기
        return new CustomUser(
                // 메일 - 비밀번호 - 권한 - 이메일도 추가로
                user.getUserMail(),
                user.getUserPassword(),
                authorities,
                user.getUserMail()
        );
    }

}
