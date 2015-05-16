package com.kpi.stepanov.rest.service.impl;

import com.kpi.stepanov.rest.entity.AIM;
import com.kpi.stepanov.rest.repository.AIMRepository;
import com.kpi.stepanov.rest.service.AIMService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AIMServiceImpl implements AIMService {

    @Autowired
    AIMRepository repository;

    @Override
    public AIM add(AIM aim) {
        return repository.saveAndFlush(aim);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }

    @Override
    public AIM edit(AIM aim) {
        return repository.saveAndFlush(aim);
    }

    @Override
    public List<AIM> getAll() {
        return repository.findAll();
    }

    @Override
    public AIM getById(long id) {
        return repository.getOne(id);
    }
}
