//package com.example.SCMS.repository;
//
//import com.example.SCMS.entity.Organization;
//import com.example.SCMS.entity.OrganizationUser;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public interface OrganizationUserRepository extends JpaRepository<OrganizationUser, Long> {
//
////    @Query("SELECT ou FROM OrganizationUser ou WHERE ou.email = :email AND ou.organization.id = :organizationId AND ou.role = 'Admin'")
////    Optional<OrganizationUser> findAdminByEmailAndOrganizationId(String email, Long organizationId);
//
//    Optional<OrganizationUser> findFirstByOrganizationIdAndFullName(Organization organization,String fullName);
//}
//


package com.example.SCMS.repository;

import com.example.SCMS.entity.Organization;
import com.example.SCMS.entity.OrganizationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizationUserRepository extends JpaRepository<OrganizationUser, Long> {

    Optional<OrganizationUser> findFirstByOrganizationIdAndFullName(Long organizationId, String fullName);


    Optional<OrganizationUser> findFirstByOrganizationAndFullName(Organization organization, String fullName);


}
