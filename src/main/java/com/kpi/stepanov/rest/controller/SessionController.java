package com.kpi.stepanov.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SessionController {
    @Autowired
    @Qualifier("sessionRegistry")
    private SessionRegistry sessionRegistry;

    @RequestMapping("users")
    public String getAllUsers() {
        List<Object> principals = sessionRegistry.getAllPrincipals();
        List<String> usersNamesList = new ArrayList<String>();
        StringBuilder result = new StringBuilder();
        for (Object principal: principals) {
            if (principal instanceof User) {
                result.append(((User) principal).getUsername() + "<br>");
            }
        }
        return result.toString();
    }
}
