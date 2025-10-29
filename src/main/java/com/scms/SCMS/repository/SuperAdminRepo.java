package com.scms.SCMS.repository;

import com.scms.SCMS.entity.SuperAdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SuperAdminRepo extends JpaRepository<SuperAdminEntity, UUID> {
    Optional<SuperAdminEntity> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
