package com.crizen.springboard.domain.auth.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
@Getter
@Setter
public class CustomUser extends User {

    private final String userName;
    private final Long userId;


    public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities, String userMail, Long userId) {
        super(username, password, authorities);
        this.userName = userMail;
        this.userId = userId;
    }

    public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, String userMail, Long userId) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.userName = userMail;
        this.userId = userId;
    }
}
