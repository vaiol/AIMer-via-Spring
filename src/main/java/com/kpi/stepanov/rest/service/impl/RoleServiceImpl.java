package com.kpi.stepanov.rest.service.impl;

import com.kpi.stepanov.rest.entity.Role;
import com.kpi.stepanov.rest.repository.RoleRepository;
import com.kpi.stepanov.rest.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository repository;

    @Override
    public Role add(Role role) {
        return repository.saveAndFlush(role);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }

    @Override
    public Role edit(Role role) {
        return repository.saveAndFlush(role);
    }

    @Override
    public List<Role> getAll() {
        return repository.findAll();
    }

    @Override
    public Role getById(long id) {
        return repository.getOne(id);
    }
}
