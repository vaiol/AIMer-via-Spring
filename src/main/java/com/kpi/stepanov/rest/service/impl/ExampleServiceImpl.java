package com.kpi.stepanov.rest.service.impl;

import com.kpi.stepanov.rest.entity.Example;
import com.kpi.stepanov.rest.repository.ExampleRepository;
import com.kpi.stepanov.rest.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleServiceImpl implements ExampleService {

    @Autowired
    ExampleRepository repo;

    @Override
    public Example add(Example example) {
        return repo.saveAndFlush(example);
    }

    @Override
    public void delete(long id) {
        repo.delete(id);
    }

    @Override
    public Example edit(Example example) {
        return repo.saveAndFlush(example);
    }

    @Override
    public List<Example> getAll() {
        return repo.findAll();
    }

    @Override
    public Example getById(long id) {
        return repo.findOne(id);
    }
}
