package com.scms.SCMS.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrganizationAdminResponse {
    private UUID id;
    private String username;
    private String email;
    private String phoneNo;
    private String organizationName;
    private String role;
    private String firstName;
    private String lastName;
    private boolean active;
}

