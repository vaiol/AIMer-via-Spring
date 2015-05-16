package com.kpi.stepanov.rest.repository;

import com.kpi.stepanov.rest.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
