package com.yusuf.security.services.appUser;

import com.yusuf.security.entities.AppUser;
import com.yusuf.security.requests.CreateUserRequest;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public interface AppUserService {
    AppUser getUser(String username) throws ResponseStatusException;

    void addRoleToUser(String username, String name) throws ResponseStatusException;

    AppUser saveUser(CreateUserRequest user) throws ResponseStatusException;

    List<AppUser> getUsers();
}
