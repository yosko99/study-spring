package com.yusuf.security.services.appUser;

import com.yusuf.security.entities.AppUser;
import com.yusuf.security.entities.Role;
import com.yusuf.security.repositories.AppUserRepository;
import com.yusuf.security.requests.CreateUserRequest;
import com.yusuf.security.services.role.RoleService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepository appUserRepository;
    private final RoleService roleService;

    @Override
    public AppUser getUser(String username) throws ResponseStatusException {
        log.info("Fetching user with username {}", username);

        AppUser user = appUserRepository.findByUsername(username);
        if (user == null) {
            throw new ResponseStatusException(
                    HttpStatusCode.valueOf(404),
                    "User with provided username not found username: " + username
            );
        }

        return user;
    }

    @Override
    public void addRoleToUser(String username, String name) throws ResponseStatusException {
        log.info("Adding role with name {} to user with username {}", name, username);

        AppUser user = getUser(username);
        Role role = roleService.getRole(name);

        user.getRoles().add(role);
    }

    @Override
    public AppUser saveUser(CreateUserRequest user) throws ResponseStatusException {
        log.info("Saving user");

        boolean existingUser = appUserRepository.findByUsername(user.username()) != null;

        if (existingUser) {
            throw new ResponseStatusException(
                    HttpStatusCode.valueOf(400),
                    "User with provided username already exists"
            );
        }

        AppUser newUser = new AppUser(
                user.name(),
                user.username(),
                user.password(),
                user.roles()
        );

        appUserRepository.save(newUser);
        return newUser;
    }

    @Override
    public List<AppUser> getUsers() {
        log.info("Fetching all users");

        return appUserRepository.findAll();
    }
}
