package com.kpi.stepanov.rest.service;

import com.kpi.stepanov.rest.entity.Step;

import java.util.List;

public interface StepService {
    Step add(Step step);
    void delete(long id);
    Step edit(Step step);
    List<Step> getAll();
    Step getById(long id);
}
