package com.yusuf.security;

import com.yusuf.security.requests.CreateRoleRequest;
import com.yusuf.security.requests.CreateUserRequest;
import com.yusuf.security.services.appUser.AppUserService;
import com.yusuf.security.services.role.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

    @Bean
    CommandLineRunner run(AppUserService appUserService, RoleService roleService) {
        return args -> {
            roleService.saveRole(new CreateRoleRequest("ROLE_USER"));
            roleService.saveRole(new CreateRoleRequest("ROLE_MANAGER"));
            roleService.saveRole(new CreateRoleRequest("ROLE_ADMIN"));
            roleService.saveRole(new CreateRoleRequest("ROLE_SUPER_ADMIN"));

            appUserService.saveUser(new CreateUserRequest("Yosko", "yosko99", "1234", List.of()));
            appUserService.saveUser(new CreateUserRequest("Azis", "azizzz", "1234", List.of()));
            appUserService.saveUser(new CreateUserRequest("Ismail", "ismailYK", "1234", List.of()));

            appUserService.addRoleToUser("yosko99", "ROLE_USER");
            appUserService.addRoleToUser("yosko99", "ROLE_SUPER_ADMIN");
            appUserService.addRoleToUser("azizzz", "ROLE_ADMIN");
            appUserService.addRoleToUser("ismailYK", "ROLE_MANAGER");
            appUserService.addRoleToUser("ismailYK", "ROLE_USER");
        };
    }
}
