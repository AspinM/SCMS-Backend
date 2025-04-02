package com.example.SCMS.response;


import com.example.SCMS.entity.Organization;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse {
    private String token;
    private String fullName;
    private String role;
    @JsonProperty("organization") // Explicitly name the JSON field
    private OrganizationDTO organization;

    public AuthResponse(String token, String fullName, String role,OrganizationDTO organization) {
        this.token = token;
        this.fullName = fullName;
        this.role = role;
        if (organization != null) {
            System.out.println("✅ Organization in AuthResponse: " + organization.getOrganizationName());
            this.organization = new OrganizationDTO(organization.getId(), organization.getOrganizationName());
        } else {
            System.out.println("❌ Organization is NULL in AuthResponse!");
        }
    }

    // Getter and Setter for token
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    // Getter and Setter for fullName
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // Getter and Setter for role
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

