package com.yusuf.security.services.role;

import com.yusuf.security.entities.Role;
import com.yusuf.security.repositories.RoleRepository;
import com.yusuf.security.requests.CreateRoleRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role getRole(String name) throws ResponseStatusException {
        log.info("Fetching role with name {}", name);

        Role role = roleRepository.findByName(name);
        if (role == null) {
            throw new ResponseStatusException(
                    HttpStatusCode.valueOf(404),
                    "Role with provided name not found name: " + name
            );
        }

        return role;
    }

    @Override
    public Role saveRole(CreateRoleRequest role) throws ResponseStatusException {
        log.info("Saving role");

        boolean existingRole = roleRepository.findByName(role.name()) != null;

        if (existingRole) {
            throw new ResponseStatusException(
                    HttpStatusCode.valueOf(400),
                    "Role with provided name already exists"
            );
        }

        Role newRole = new Role(role.name());

        roleRepository.save(newRole);
        return newRole;
    }
}
