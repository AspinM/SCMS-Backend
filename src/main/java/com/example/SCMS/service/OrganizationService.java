package com.example.SCMS.service;


import com.example.SCMS.entity.Organization;
import com.example.SCMS.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    public List<Organization> getAllProducts() {
        return organizationRepository.findAll();
    }

    public Organization addOrganization(Organization organization) {
        try {
            return organizationRepository.save(organization);
        } catch (Exception e) {
            throw new RuntimeException("Error saving organization", e);
        }
    }

}
