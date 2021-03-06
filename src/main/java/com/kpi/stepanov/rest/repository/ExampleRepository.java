package com.kpi.stepanov.rest.repository;


import com.kpi.stepanov.rest.entity.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExampleRepository extends JpaRepository<Example, Long> {
}