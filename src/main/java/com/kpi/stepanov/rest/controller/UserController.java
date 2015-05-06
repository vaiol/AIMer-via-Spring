package com.kpi.stepanov.rest.controller;

import com.kpi.stepanov.rest.entity.User;
import com.kpi.stepanov.rest.service.UserService;
import com.kpi.stepanov.rest.util.StringUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.security.Principal;

@RestController
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/user")
    public org.springframework.security.core.userdetails.User user() {
        return (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public User addExample(@Valid @RequestParam(value = "email") String email,
                           @Valid @RequestParam(value = "password") String password) {
        if (StringUtil.isNullOrEmpty(email) && StringUtil.isNullOrEmpty(password)) {
            throw new IllegalArgumentException();
        }
        return userService.add(new User(email, password));
    }
}
