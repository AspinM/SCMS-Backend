package com.scms.SCMS.responses;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrganizationAdminLoginResponse {
    private String accessToken;
    private String refreshToken;
    private String sessionId;
    private OrganizationDetails organizationDetails;
}



