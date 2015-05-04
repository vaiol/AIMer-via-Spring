package com.kpi.stepanov.rest.controller;

import com.kpi.stepanov.rest.entity.Example;
import com.kpi.stepanov.rest.repository.ExampleRepository;
import com.kpi.stepanov.rest.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/example")
public class ExampleController {
    @Resource
    private ExampleService exampleService;

    //@RequestParam(value = "message", defaultValue = "Hello, World!") String message
    //@RequestBody Example updatedExample
    //@PathVariable Integer id

    @RequestMapping(method = RequestMethod.GET)
    public List<Example> findItems() {
        return exampleService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Example addExample(@RequestParam(value = "message", defaultValue = "Hello, World!") String message) {
        return exampleService.add(new Example(message));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Example findItem(@PathVariable Integer id) {
        return exampleService.getById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Example updateExample(@RequestParam(value = "message", defaultValue = "Hello, World!") String message,
                                 @PathVariable Integer id) {
        return exampleService.edit(new Example(id, message));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteExample(@PathVariable Integer id) {
        exampleService.delete(id);
    }
}
