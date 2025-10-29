package com.scms.SCMS.controller;

import com.scms.SCMS.requests.StaffRequest;
import com.scms.SCMS.responses.ApiResponse;
import com.scms.SCMS.responses.StaffResponse;
import com.scms.SCMS.service.StaffService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/org-admin/staff")
@RequiredArgsConstructor
public class StaffController {

    private final StaffService staffService;

    @PostMapping("/add/{orgAdminId}")
    public ResponseEntity<ApiResponse<StaffResponse>> addStaff(
            @PathVariable UUID orgAdminId,
            @Valid @RequestBody StaffRequest request) {

        StaffResponse response = staffService.addStaff(orgAdminId, request);
        return ResponseEntity.ok(ApiResponse.success("Staff added successfully", response));
    }

    @GetMapping("/list/{orgAdminId}")
    public ResponseEntity<ApiResponse<List<StaffResponse>>> getAllStaff(
            @PathVariable UUID orgAdminId) {

        List<StaffResponse> staffList = staffService.getStaffByOrgAdmin(orgAdminId);
        return ResponseEntity.ok(ApiResponse.success("Staff list fetched", staffList));
    }
}

