package com.kpi.stepanov.rest.service.impl;

import com.kpi.stepanov.rest.entity.User;
import com.kpi.stepanov.rest.repository.UserRepository;
import com.kpi.stepanov.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public User add(User user) {
        return repository.saveAndFlush(user);
    }

    @Override
    public User edit(User user) {
        return repository.saveAndFlush(user);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User getById(long id) {
        return repository.getOne(id);
    }

    @Override
    public User getByEmail(String email) {
        return repository.fingByEmail(email);
    }
}
