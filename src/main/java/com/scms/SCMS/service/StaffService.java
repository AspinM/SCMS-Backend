package com.scms.SCMS.service;

import com.scms.SCMS.entity.OrganizationAdminEntity;
import com.scms.SCMS.entity.StaffEntity;
import com.scms.SCMS.repository.OrganizationAdminRepo;
import com.scms.SCMS.repository.StaffRepo;
import com.scms.SCMS.requests.StaffRequest;
import com.scms.SCMS.responses.StaffResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StaffService {

    private final StaffRepo staffRepo;
    private final OrganizationAdminRepo organizationAdminRepo;

    public StaffResponse addStaff(UUID orgAdminId, StaffRequest request) {
        OrganizationAdminEntity orgAdmin = organizationAdminRepo.findById(orgAdminId)
                .orElseThrow(() -> new RuntimeException("Organization admin not found"));

        if (staffRepo.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists for another staff member");
        }

        StaffEntity staff = new StaffEntity();
        staff.setFullName(request.getFullName());
        staff.setEmail(request.getEmail());
        staff.setPhoneNo(request.getPhoneNo());
        staff.setRole(request.getRole());
        staff.setSpecialization(request.getSpecialization());
        staff.setQualification(request.getQualification());
        staff.setDepartment(request.getDepartment());
        staff.setOrganizationAdmin(orgAdmin);
        staff.setActive(true);

        StaffEntity saved = staffRepo.save(staff);

        return StaffResponse.builder()
                .id(saved.getId())
                .fullName(saved.getFullName())
                .email(saved.getEmail())
                .phoneNo(saved.getPhoneNo())
                .role(saved.getRole())
                .specialization(saved.getSpecialization())
                .qualification(saved.getQualification())
                .department(saved.getDepartment())
                .active(saved.isActive())
                .build();
    }

    public List<StaffResponse> getStaffByOrgAdmin(UUID orgAdminId) {
        return staffRepo.findByOrganizationAdminId(orgAdminId)
                .stream()
                .map(staff -> StaffResponse.builder()
                        .id(staff.getId())
                        .fullName(staff.getFullName())
                        .email(staff.getEmail())
                        .phoneNo(staff.getPhoneNo())
                        .role(staff.getRole())
                        .specialization(staff.getSpecialization())
                        .qualification(staff.getQualification())
                        .department(staff.getDepartment())
                        .active(staff.isActive())
                        .build())
                .collect(Collectors.toList());
    }
}

