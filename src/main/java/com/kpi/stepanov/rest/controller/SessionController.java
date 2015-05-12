package com.kpi.stepanov.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @Secured("ROLE_ADMIN")
    @RequestMapping("users")
    public List<User> getAllUsers() {
        List<Object> principals = sessionRegistry.getAllPrincipals();
        List<User> users  = new ArrayList<User>(principals.size());
        for (Object principal: principals) {
            if (principal instanceof User) {
                users.add(((User) principal));
            }
        }
        return users;
    }
}
