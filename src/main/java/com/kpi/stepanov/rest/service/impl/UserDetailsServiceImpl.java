package com.kpi.stepanov.rest.service.impl;

import com.kpi.stepanov.rest.entity.Role;
import com.kpi.stepanov.rest.entity.User;
import com.kpi.stepanov.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.getByEmail(email);

        if (user == null) {
            System.out.println("user not found");
            throw new UsernameNotFoundException("User: " + email + " not found");
        }
        System.out.println(user.getEmail() + ", " + user.getPassword() + ", " + user.getRoles());
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                user.isEnabled(),
                ! user.isExpired(),
                ! user.isExpired(),
                ! user.isLocked(),
                toGrantedAuthorities(user.getRoles())
        );
    }

    public static Set<GrantedAuthority> toGrantedAuthorities(Set<Role> roles){
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        if (roles != null) {
            for (Role role : roles) {
                authorities.add(new SimpleGrantedAuthority(role.getRole()));
            }
        }
        return authorities;
    }

}
