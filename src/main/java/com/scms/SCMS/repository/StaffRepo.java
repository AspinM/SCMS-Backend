package com.scms.SCMS.repository;


import com.scms.SCMS.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StaffRepo extends JpaRepository<StaffEntity, UUID> {
    List<StaffEntity> findByOrganizationAdminId(UUID orgAdminId);
    boolean existsByEmail(String email);
}
