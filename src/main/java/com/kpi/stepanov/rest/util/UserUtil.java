package com.kpi.stepanov.rest.util;

import com.kpi.stepanov.rest.entity.User;

import java.security.Principal;

public abstract class UserUtil {
    public static boolean compareUsers(User user, Principal principal) {
        return ((org.springframework.security.core.userdetails.User) principal).getUsername().equals(user.getEmail());
    }

}
