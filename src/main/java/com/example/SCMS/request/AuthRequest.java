package com.example.SCMS.request;

public class AuthRequest {
    private String organizationName;
    private String fullName;
    private String password;

    // Getter and Setter for organizationName
    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    // Getter and Setter for username
    public String getFullName() {
        return fullName;
    }

    public void setUsername(String fullName) {
        this.fullName = fullName;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
