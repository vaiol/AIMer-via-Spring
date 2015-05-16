package com.kpi.stepanov.rest.repository;

import com.kpi.stepanov.rest.entity.Step;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StepRepository extends JpaRepository<Step, Long> {
}
