package com.scms.SCMS.responses;


import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class OrganizationDetails {
    private String organizationName;
    private String organizationAddress;
    private String email;
    private UUID id;
}
