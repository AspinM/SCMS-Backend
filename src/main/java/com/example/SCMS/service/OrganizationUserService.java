package com.example.SCMS.service;

import com.example.SCMS.entity.Organization;
import com.example.SCMS.entity.OrganizationUser;
import com.example.SCMS.entity.Role;
import com.example.SCMS.repository.OrganizationRepository;
import com.example.SCMS.repository.OrganizationUserRepository;
import com.example.SCMS.request.AuthRequest;
import com.example.SCMS.response.AuthResponse;
import com.example.SCMS.response.OrganizationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrganizationUserService {

    @Autowired
    private OrganizationUserRepository organizationUserRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;







    public OrganizationUser addAdmin(Long organizationId, OrganizationUser adminUser) {
        Optional<Organization> organization = organizationRepository.findById(organizationId);

        if (organization.isPresent()) {
            adminUser.setOrganization(organization.get());
            adminUser.setRole(Role.ADMIN); // Ensure role is ADMIN
            adminUser.setPassword(passwordEncoder.encode(adminUser.getPassword()));
            return organizationUserRepository.save(adminUser);
        } else {
            throw new RuntimeException("Organization not found!");
        }
    }

    // ✅ Add Staff API (Only Admin Can Add Staff)
    public OrganizationUser addStaff(Long adminId, Long organizationId, OrganizationUser staffUser) {
        Optional<OrganizationUser> adminUser = organizationUserRepository.findById(adminId);

        if (adminUser.isPresent() && adminUser.get().getRole() == Role.ADMIN) {
            Optional<Organization> organization = organizationRepository.findById(organizationId);

            if (organization.isPresent()) {
                staffUser.setOrganization(organization.get());
                staffUser.setPassword(passwordEncoder.encode(staffUser.getPassword()));
                return organizationUserRepository.save(staffUser);
            } else {
                throw new RuntimeException("Organization not found!");
            }
        } else {
            throw new RuntimeException("Only ADMIN users can add staff!");
        }
    }

//    public AuthResponse login(AuthRequest authRequest) {
//        // 🔍 Find organization by name
//        Optional<Organization> organizationOpt = organizationRepository.findByOrganizationName(authRequest.getOrganizationName());
//
//        if (organizationOpt.isEmpty()) {
//            throw new RuntimeException("Organization not found!");
//        }
//
//        Organization organization = organizationOpt.get();
//
//        System.out.println("Organization Found: " + organization.getId() + " - " + organization.getOrganizationName());
//
//        // 🔍 Find user by organization and username
////        Optional<OrganizationUser> userOpt = organizationUserRepository.findFirstByOrganizationIdAndFullName(organization.getId(), authRequest.getFullName());
//
//        Optional<OrganizationUser> userOpt = organizationUserRepository.findFirstByOrganizationAndFullName(organization, authRequest.getFullName());
//
//        if (userOpt.isEmpty()) {
//            throw new RuntimeException("Invalid username or organization!");
//        }
//
//        OrganizationUser user = userOpt.get();
//
//        // 🔐 Check password
//        if (!passwordEncoder.matches(authRequest.getPassword(), user.getPassword())) {
//            throw new RuntimeException("Invalid password!");
//        }
//
//        // ✅ Generate JWT token
//        String token = jwtService.generateToken(user.getFullName());
//        OrganizationDTO organizationDTO = new OrganizationDTO(organization.getId(), organization.getOrganizationName());
//
//        System.out.println("organizationDTO"+organizationDTO);
//
//        // ✅ Return token in response
//        return new AuthResponse(token, user.getFullName(), user.getRole().toString(),organizationDTO);
//    }

    public AuthResponse login(AuthRequest authRequest) {
        // Find organization
        Optional<Organization> organizationOpt = organizationRepository.findByOrganizationName(authRequest.getOrganizationName());
        if (organizationOpt.isEmpty()) {
            throw new RuntimeException("Organization not found!");
        }

        Organization organization = organizationOpt.get();
        System.out.println("✅ Organization Found: " + organization.getId() + " - " + organization.getOrganizationName());

        // Find user
        Optional<OrganizationUser> userOpt = organizationUserRepository.findFirstByOrganizationAndFullName(organization, authRequest.getFullName());
        if (userOpt.isEmpty()) {
            throw new RuntimeException("Invalid username or organization!");
        }

        OrganizationUser user = userOpt.get();

        // Check password
        if (!passwordEncoder.matches(authRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password!");
        }

        // Generate JWT token
        String token = jwtService.generateToken(user.getFullName());

        // Create OrganizationDTO
        OrganizationDTO organizationDTO = new OrganizationDTO(organization.getId(), organization.getOrganizationName());

        System.out.println("🚀 organizationDTO before response: " + organizationDTO.getOrganizationName());

        // Return token and organization details in response
        return new AuthResponse(token, user.getFullName(), user.getRole().toString(), organizationDTO);
    }

}

