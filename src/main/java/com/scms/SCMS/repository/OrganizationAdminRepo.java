package com.scms.SCMS.repository;


import com.scms.SCMS.entity.OrganizationAdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OrganizationAdminRepo extends JpaRepository<OrganizationAdminEntity, UUID> {
    Optional<OrganizationAdminEntity> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
