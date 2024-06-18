package com.api.crud.services;

import com.api.crud.enumer.ERole;
import com.api.crud.models.entities.RoleEntity;
import com.api.crud.repositories.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    IRoleRepository roleRepository;

    public Optional<RoleEntity> getByRolName(ERole name) {
        return roleRepository.findByRolName(name);
    }

}
