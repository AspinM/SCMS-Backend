package com.scms.SCMS.controller;


import com.scms.SCMS.requests.OrganizationAdminLoginRequest;
import com.scms.SCMS.requests.OrganizationAdminRequest;
import com.scms.SCMS.responses.ApiResponse;
import com.scms.SCMS.responses.OrganizationAdminLoginResponse;
import com.scms.SCMS.responses.OrganizationAdminResponse;
import com.scms.SCMS.service.OrganizationAdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organization-admin")
@RequiredArgsConstructor
public class OrganizationAdminController {

    private final OrganizationAdminService organizationAdminService;

    @PostMapping("/create/{superAdminUsername}")
    public ResponseEntity<ApiResponse<OrganizationAdminResponse>> createOrganizationAdmin(
            @PathVariable String superAdminUsername,
            @Valid @RequestBody OrganizationAdminRequest request) {

        OrganizationAdminResponse response = organizationAdminService.createOrganizationAdmin(request, superAdminUsername);
        return ResponseEntity.ok(ApiResponse.success("Organization Admin created successfully", response));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<OrganizationAdminLoginResponse>> login(
            @Valid @RequestBody OrganizationAdminLoginRequest request) {

        OrganizationAdminLoginResponse response = organizationAdminService.login(request);
        return ResponseEntity.ok(ApiResponse.success("Login successful", response));
    }
}

