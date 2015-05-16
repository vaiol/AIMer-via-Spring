package com.kpi.stepanov.rest.service.impl;

import com.kpi.stepanov.rest.entity.Step;
import com.kpi.stepanov.rest.repository.StepRepository;
import com.kpi.stepanov.rest.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StepServiceImpl implements StepService {

    @Autowired
    StepRepository repository;

    @Override
    public Step add(Step step) {
        return repository.saveAndFlush(step);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }

    @Override
    public Step edit(Step step) {
        return repository.saveAndFlush(step);
    }

    @Override
    public List<Step> getAll() {
        return repository.findAll();
    }

    @Override
    public Step getById(long id) {
        return repository.getOne(id);
    }
}
