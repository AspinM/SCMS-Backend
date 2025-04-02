package com.example.SCMS.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;

@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("fullName")
    @Column(nullable = false)
    private String fullName;

    @JsonProperty("email")
    @Column(nullable = false, unique = true)
    private String email;

    @JsonProperty("phoneNumber")
    @Column(nullable = false)
    private String phoneNumber;

    @JsonProperty("gender")
    @Column(nullable = false)
    private String gender;

    @JsonProperty("age")
    @Column(nullable = false)
    private int age;

    @JsonProperty("address")
    @Column(nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = false)
    @JsonProperty("organization")
    private Organization organization;

    @JsonProperty("createdAt")
    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @JsonProperty("updatedAt")
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
