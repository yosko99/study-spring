package com.yusuf.security.controllers;

import com.yusuf.security.entities.Role;
import com.yusuf.security.requests.CreateRoleRequest;
import com.yusuf.security.services.role.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/roles")
public class RoleController {
    private final RoleService roleService;

    @PostMapping
    public Role createRole(@RequestBody CreateRoleRequest role) {
        return roleService.saveRole(role);
    }
}
