//package com.example.SCMS.entity;
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//import java.util.Date;
//
//@Entity
//@Table(name = "organization_users")
//@Getter
//@Setter
//@NoArgsConstructor
//public class OrganizationUser {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "organization_id", nullable = false)
//    private Organization organization;  // ✅ Add this field
//
//    @JsonProperty("role")
//    @Column(nullable = false)
//    @Enumerated(EnumType.STRING) // ✅ This ensures the Role is stored as a String in DB
//    private Role role;
//
//    @JsonProperty("email")
//    @Column(nullable = false, unique = true)
//    private String email;
//
//    @JsonProperty("username")
//    @Column(nullable = false)
//    private String username;
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
//
//    // ✅ Add this setter method if Lombok is not working properly
//    public void setOrganization(Organization organization) {
//        this.organization = organization;
//    }
//
//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }
//}


package com.example.SCMS.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;

@Entity
@Table(name = "organization_users")
@Getter
@Setter
@NoArgsConstructor
public class OrganizationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = false)
    @JsonProperty("organization")
    private Organization organization;

    @JsonProperty("fullName")
    @Column(name = "full_name", nullable = false)
    private String fullName;

    @JsonProperty("employeeId")
    @Column(name = "employee_id", nullable = false, unique = true)
    private String employeeId;

    @JsonProperty("role")
    @Column(nullable = false)
    @Enumerated(EnumType.STRING) // ✅ Role stored as String in DB
    private Role role;

    @JsonProperty("email")
    @Column(nullable = false, unique = true)
    private String email;

    @JsonProperty("phoneNumber")
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @JsonProperty("address")
    @Column(nullable = false)
    private String address;

    @JsonProperty("password")
    @Column(nullable = false)
    private String password; // Store securely (hash before saving)

    @CreationTimestamp
    @JsonProperty("createdAt")
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @JsonProperty("updatedAt")
    @Column(name = "updated_at")
    private Date updatedAt;

    // ✅ Setters if Lombok is not working properly
    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getFullName(){
        return fullName;
    }


}
