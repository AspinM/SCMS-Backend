package com.scms.SCMS.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StaffRequest {

    @NotBlank
    private String fullName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String phoneNo;

    @NotBlank
    private String role; // DOCTOR, NURSE, RECEPTIONIST

    private String specialization;
    private String qualification;
    private String department;
}
