package com.api.crud.repositories;

import com.api.crud.enumer.ERole;
import com.api.crud.models.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity, Long> {

    Optional<RoleEntity> findByRolName(ERole name);
}
