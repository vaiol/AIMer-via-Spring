package com.kpi.stepanov.rest.controller;

import com.kpi.stepanov.rest.entity.User;
import com.kpi.stepanov.rest.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public User getCurrent() {
        return userService.getByEmail("");
    }

    @RequestMapping(method = RequestMethod.POST)
    public User addExample(@Valid @RequestParam(value = "email") String email,
                           @Valid @RequestParam(value = "password") String password) {
        return userService.add(new User(email, password));
    }


}
