package com.kpi.stepanov.rest.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {
    private int id;
    private String role;
    private Set<User> users;

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = { @JoinColumn(name = "role_id", referencedColumnName="id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "user_id", referencedColumnName="id", nullable = false, updatable = false) })
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
