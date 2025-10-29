package com.scms.SCMS.service;

import com.scms.SCMS.entity.OrganizationAdminEntity;
import com.scms.SCMS.entity.SuperAdminEntity;
import com.scms.SCMS.repository.OrganizationAdminRepo;
import com.scms.SCMS.repository.SuperAdminRepo;
import com.scms.SCMS.requests.OrganizationAdminLoginRequest;
import com.scms.SCMS.requests.OrganizationAdminRequest;
import com.scms.SCMS.responses.OrganizationAdminLoginResponse;
import com.scms.SCMS.responses.OrganizationAdminResponse;
import com.scms.SCMS.responses.OrganizationDetails;
import com.scms.SCMS.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationAdminService {

    private final OrganizationAdminRepo organizationAdminRepo;
    private final SuperAdminRepo superAdminRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public OrganizationAdminResponse createOrganizationAdmin(OrganizationAdminRequest request, String superAdminUsername) {
        // Validate
        if (organizationAdminRepo.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists!");
        }
        if (organizationAdminRepo.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists!");
        }

        // Find super admin who creates this org admin
        SuperAdminEntity creator = superAdminRepo.findByUsername(superAdminUsername)
                .orElseThrow(() -> new RuntimeException("Super Admin not found!"));

        // Create entity
        OrganizationAdminEntity admin = new OrganizationAdminEntity();
        admin.setUsername(request.getUsername());
        admin.setEmail(request.getEmail());
        admin.setPhoneNo(request.getPhoneNo());
        admin.setOrganizationName(request.getOrganizationName());
        admin.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        admin.setRole("ORG_ADMIN");
        admin.setFirstName(request.getFirstName());
        admin.setLastName(request.getLastName());
        admin.setActive(true);
        admin.setCreatedBy(creator);

        OrganizationAdminEntity saved = organizationAdminRepo.save(admin);

        return OrganizationAdminResponse.builder()
                .id(saved.getId())
                .username(saved.getUsername())
                .email(saved.getEmail())
                .phoneNo(saved.getPhoneNo())
                .organizationName(saved.getOrganizationName())
                .role(saved.getRole())
                .firstName(saved.getFirstName())
                .lastName(saved.getLastName())
                .active(saved.getActive())
                .build();
    }

    public OrganizationAdminLoginResponse login(OrganizationAdminLoginRequest request) {

        OrganizationAdminEntity admin = organizationAdminRepo.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));

        if (!passwordEncoder.matches(request.getPassword(), admin.getPasswordHash())) {
            throw new RuntimeException("Invalid username or password");
        }

        String accessToken = jwtService.generateAccessToken(admin.getUsername());
        String refreshToken = jwtService.generateRefreshToken(admin.getUsername());
        String sessionId = jwtService.generateSessionId();

        return OrganizationAdminLoginResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .sessionId(sessionId)
                .organizationDetails(OrganizationDetails.builder()
                        .organizationName(admin.getOrganizationName())
                        .organizationAddress(admin.getUsername())
                        .id(admin.getId())
                        .email(admin.getEmail())
                        .build())
                .build();
    }
}

