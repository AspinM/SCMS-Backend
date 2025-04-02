package com.example.SCMS.controller;


import com.example.SCMS.entity.Patient;
import com.example.SCMS.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/register/{organizationId}")
    public Patient registerPatient(@PathVariable Long organizationId, @RequestBody Patient patient) {
        return patientService.registerPatient(organizationId, patient);
    }
}

