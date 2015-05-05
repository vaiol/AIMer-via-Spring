package com.kpi.stepanov.rest.service;

import com.kpi.stepanov.rest.entity.Example;

import java.util.List;

public interface ExampleService {
    Example add(Example example);
    void delete(long id);
    Example edit(Example example);
    List<Example> getAll();
    Example getById(long id);

    List<Example> getByMessage(String message);
}
