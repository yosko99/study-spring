package com.yusuf.security.controllers;

import com.yusuf.security.entities.AppUser;
import com.yusuf.security.requests.CreateUserRequest;
import com.yusuf.security.services.appUser.AppUserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class AppUserController {
    private final AppUserServiceImpl appUserService;

    @GetMapping
    public List<AppUser> getUsers() {
        return appUserService.getUsers();
    }

    @GetMapping("/{username}")
    public AppUser getUser(@PathVariable("username") String username) {
        return appUserService.getUser(username);
    }

    @PostMapping
    public AppUser saveUser(@RequestBody CreateUserRequest user) {
        return appUserService.saveUser(user);
    }

    @PutMapping("/{username}/role/{roleName}")
    public ResponseEntity<?> addRoleToUser(
            @PathVariable("username") String username,
            @PathVariable("roleName") String roleName
    ) {
        appUserService.addRoleToUser(username, roleName);
        return ResponseEntity.ok(200);
    }
}
