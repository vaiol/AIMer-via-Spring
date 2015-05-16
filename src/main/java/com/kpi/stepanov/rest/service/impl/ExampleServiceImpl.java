package com.kpi.stepanov.rest.service.impl;

import com.kpi.stepanov.rest.entity.Example;
import com.kpi.stepanov.rest.repository.ExampleRepository;
import com.kpi.stepanov.rest.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleServiceImpl implements ExampleService {

    @Autowired
    ExampleRepository repository;

    @Override
    public Example add(Example example) {
        return repository.saveAndFlush(example);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }

    @Override
    public Example edit(Example example) {
        return repository.saveAndFlush(example);
    }

    @Override
    public List<Example> getAll() {
        return repository.findAll();
    }

    @Override
    public Example getById(long id) {
        return repository.findOne(id);
    }

}
