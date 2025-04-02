package com.example.SCMS.controller;

import com.example.SCMS.entity.Organization;
import com.example.SCMS.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/api/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @PostMapping("/add")
    public Organization createOrganization(@RequestBody Organization organization) {
        System.out.println("Received Organization: " + organization);
        return organizationService.addOrganization(organization);
    }

}
