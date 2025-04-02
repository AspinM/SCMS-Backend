//package com.example.SCMS.entity;
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import java.util.Date;
//
//@Entity
//@Table(name = "organization")
//@Getter
//@Setter
//@NoArgsConstructor
//public class Organization {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @JsonProperty("organizationName")
//    @Column(name = "organization_name", nullable = false)
//    private String organizationName;
//
//    @JsonProperty("phoneNumber")
//    @Column(name = "phone_number", nullable = false)
//    private String phoneNumber;
//
//    @CreationTimestamp
//    @Column(updatable = false, name = "created_at")
//    private Date createdAt;
//
//    @UpdateTimestamp
//    @Column(name = "updated_at")
//    private Date updatedAt;
//}


package com.example.SCMS.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

@Entity
@Table(name = "organization")
@Getter
@Setter
@NoArgsConstructor
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("organizationName")
    @Column(name = "organization_name", nullable = false)
    private String organizationName;

    @JsonProperty("organizationType")
    @Column(name = "organization_type", nullable = false)
    private String organizationType;

    @JsonProperty("physicalAddress")
    @Column(name = "physical_address", nullable = false)
    private String physicalAddress;

    @JsonProperty("phoneNumber")
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @JsonProperty("email")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @CreationTimestamp
    @JsonProperty("createdAt")
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @JsonProperty("updatedAt")
    @Column(name = "updated_at")
    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public String getOrganizationName() {
        return organizationName;
    }
}
