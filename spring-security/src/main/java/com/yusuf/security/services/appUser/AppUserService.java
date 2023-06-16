package com.yusuf.security.services.appUser;

import com.yusuf.security.entities.AppUser;
import com.yusuf.security.entities.Role;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

public interface AppUserService {
    AppUser getUser(String username) throws ResponseStatusException;

    Role getRole(String name) throws ResponseStatusException;

    void addRoleToUser(String username, String name) throws ResponseStatusException;

    AppUser saveUser(AppUser user) throws ResponseStatusException;

    Role saveRole(Role role) throws ResponseStatusException;

    List<AppUser> getUsers();

}
