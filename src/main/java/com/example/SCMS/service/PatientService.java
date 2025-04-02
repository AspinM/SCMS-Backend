package com.example.SCMS.service;

import com.example.SCMS.entity.Organization;
import com.example.SCMS.entity.Patient;
import com.example.SCMS.repository.OrganizationRepository;
import com.example.SCMS.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    public Patient registerPatient(Long organizationId, Patient patient) {
        Organization organization = organizationRepository.findById(organizationId)
                .orElseThrow(() -> new RuntimeException("Organization not found"));

        patient.setOrganization(organization);
        return patientRepository.save(patient);
    }
}
