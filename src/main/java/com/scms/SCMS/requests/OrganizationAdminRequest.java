package com.scms.SCMS.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OrganizationAdminRequest {

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Phone number is required")
    private String phoneNo;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Organization name is required")
    private String organizationName;

    private String firstName;
    private String lastName;
}

