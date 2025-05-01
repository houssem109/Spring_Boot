package com.houssem.pcs.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.houssem.pcs.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
Role findByRole(String role);
}
