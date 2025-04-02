package com.example.SCMS.controller;

import com.example.SCMS.entity.OrganizationUser;
import com.example.SCMS.request.AuthRequest;
import com.example.SCMS.response.AuthResponse;
import com.example.SCMS.service.OrganizationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/api/organization-users")
public class OrganizationUserController {

    @Autowired
    private OrganizationUserService organizationUserService;

    @PostMapping("/addAdmin/{organizationId}")
    public OrganizationUser addAdmin(@PathVariable Long organizationId, @RequestBody OrganizationUser adminUser) {
        return organizationUserService.addAdmin(organizationId, adminUser);
    }

    // ✅ API for Adding Staff (Only Admin Can Add Staff)
    @PostMapping("/addStaff/{adminId}/{organizationId}")
    public OrganizationUser addStaff(@PathVariable Long adminId, @PathVariable Long organizationId, @RequestBody OrganizationUser staffUser) {
        return organizationUserService.addStaff(adminId, organizationId, staffUser);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        return organizationUserService.login(authRequest);
    }
}

