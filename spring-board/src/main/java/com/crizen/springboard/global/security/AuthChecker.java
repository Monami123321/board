package com.crizen.springboard.global.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthChecker {
    // userdetail에서 내가 설정한 관리자 권한 있는지 확인하기
    public boolean isAdmin(UserDetails user) {
        for (GrantedAuthority auth : user.getAuthorities()) {
            if (auth.getAuthority().equals("ROLE_ADMIN")) {
                return true;
            }
        }
        return false;
    }
}
