package com.kpi.stepanov.rest.service;

import com.kpi.stepanov.rest.entity.User;

import java.util.List;

public interface UserService {
    User add(User user);
    User edit(User user);
    List<User> getAll();
    User getById(long id);
    User getByEmail(String email);
}
