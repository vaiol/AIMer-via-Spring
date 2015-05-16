package com.kpi.stepanov.rest.service;

import com.kpi.stepanov.rest.entity.Role;

import java.util.List;

public interface RoleService {
    Role add(Role role);
    void delete(long id);
    Role edit(Role role);
    List<Role> getAll();
    Role getById(long id);
}
