package com.yusuf.security.requests;

import com.yusuf.security.entities.Role;

import java.util.Collection;

public record CreateUserRequest(
        String name,
        String username,
        String password,
        Collection<Role> roles) {
}
