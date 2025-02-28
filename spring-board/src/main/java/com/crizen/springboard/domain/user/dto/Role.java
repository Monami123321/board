package com.crizen.springboard.domain.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Role {
    private Long roleId;
    private String roleName;
    private String roleDescription;
}
