package com.scms.SCMS.requests;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OrganizationAdminLoginRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
