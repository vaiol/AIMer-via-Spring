package com.kpi.stepanov.rest.service;

import com.kpi.stepanov.rest.entity.AIM;

import java.util.List;

public interface AIMService  {
    AIM add(AIM aim);
    void delete(long id);
    AIM edit(AIM aim);
    List<AIM> getAll();
    AIM getById(long id);
}
