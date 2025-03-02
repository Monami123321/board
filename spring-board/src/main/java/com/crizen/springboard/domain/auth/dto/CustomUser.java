package com.crizen.springboard.domain.auth.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUser extends User {

    private final String userMail;

    public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities, String userMail) {
        super(username, password, authorities);
        this.userMail = userMail;
    }

    public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, String userMail) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.userMail = userMail;
    }
}
