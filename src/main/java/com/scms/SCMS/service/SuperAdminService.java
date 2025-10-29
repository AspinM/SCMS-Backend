package com.scms.SCMS.service;

import com.scms.SCMS.entity.SuperAdminEntity;
import com.scms.SCMS.repository.SuperAdminRepo;
import com.scms.SCMS.requests.SuperAdminRequest;
import com.scms.SCMS.responses.SuperAdminResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SuperAdminService {

    private final SuperAdminRepo superAdminRepo;
    private final PasswordEncoder passwordEncoder;

    public SuperAdminResponse createSuperAdmin(SuperAdminRequest request) {
        if (superAdminRepo.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists!");
        }

        if (superAdminRepo.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists!");
        }

        SuperAdminEntity admin = new SuperAdminEntity();
        admin.setUsername(request.getUsername());
        admin.setEmail(request.getEmail());
        admin.setPhoneNo(request.getPhoneNo());
        admin.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        admin.setRole("SUPER_ADMIN");
        admin.setFirstName(request.getFirstName());
        admin.setLastName(request.getLastName());
        admin.setActive(true);

        SuperAdminEntity saved = superAdminRepo.save(admin);

        return SuperAdminResponse.builder()
                .id(saved.getId())
                .username(saved.getUsername())
                .email(saved.getEmail())
                .role(saved.getRole())
                .firstName(saved.getFirstName())
                .lastName(saved.getLastName())
                .active(saved.getActive())
                .build();
    }
}
