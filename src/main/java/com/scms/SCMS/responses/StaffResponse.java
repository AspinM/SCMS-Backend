package com.scms.SCMS.responses;


import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class StaffResponse {
    private UUID id;
    private String fullName;
    private String email;
    private String phoneNo;
    private String role;
    private String specialization;
    private String qualification;
    private String department;
    private boolean active;
}

