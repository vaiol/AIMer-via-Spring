package com.kpi.stepanov.rest.controller;

import com.kpi.stepanov.rest.entity.ExampleEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class ExampleController {
    private static final String template = "Hello, %s!";
    private final AtomicInteger counter = new AtomicInteger();

    @RequestMapping("/hello")
    public ExampleEntity hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new ExampleEntity(counter.incrementAndGet(), String.format(template, name));
    }
}
