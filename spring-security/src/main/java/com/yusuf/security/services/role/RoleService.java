package com.yusuf.security.services.role;

import com.yusuf.security.entities.Role;
import com.yusuf.security.requests.CreateRoleRequest;
import org.springframework.web.server.ResponseStatusException;

public interface RoleService {
    Role saveRole(CreateRoleRequest role) throws ResponseStatusException;
    Role getRole(String name) throws ResponseStatusException;
}
