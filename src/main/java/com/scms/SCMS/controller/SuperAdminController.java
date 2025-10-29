package com.scms.SCMS.controller;

import com.scms.SCMS.requests.SuperAdminRequest;
import com.scms.SCMS.responses.ApiResponse;
import com.scms.SCMS.responses.SuperAdminResponse;
import com.scms.SCMS.service.SuperAdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/super-admin")
@RequiredArgsConstructor
public class SuperAdminController {

    private final SuperAdminService superAdminService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<SuperAdminResponse>> createSuperAdmin(
            @Valid @RequestBody SuperAdminRequest request) {

        SuperAdminResponse response = superAdminService.createSuperAdmin(request);
        return ResponseEntity.ok(ApiResponse.success("Super Admin created successfully", response));
    }
}
