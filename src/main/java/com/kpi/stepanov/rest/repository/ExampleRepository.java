package com.kpi.stepanov.rest.repository;


import com.kpi.stepanov.rest.entity.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ExampleRepository extends JpaRepository<Example, Long> {
    @Query("SELECT e FROM Example e WHERE e.id = :id")
    Example findById(@Param("id") long id);
}