package com.example.SCMS.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrganizationDTO {
    private Long id;
    private String organizationName;

    public OrganizationDTO() {}

    public OrganizationDTO(Long id, String organizationName) {
        this.id = id;
        this.organizationName = organizationName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    @Override
    public String toString() {
        return "OrganizationDTO{id=" + id + ", organizationName='" + organizationName + "'}";
    }

    public Long getId() {
        return id;
    }
}

