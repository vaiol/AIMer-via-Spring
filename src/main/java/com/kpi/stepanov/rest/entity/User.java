package com.kpi.stepanov.rest.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    private Long id;
    private String email;
    private String password;
    private boolean enabled;
    private boolean locked;
    private boolean expired;
    private Set<AIM> aims;
    private Set<AIM> subscriptions;
    private Set<Role> roles;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Column(nullable = false)
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Column(nullable = false)
    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    @Column(nullable = false)
    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    @OneToMany(mappedBy = "creator", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<AIM> getAims() {
        return aims;
    }

    public void setAims(Set<AIM> aims) {
        this.aims = aims;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "subscribers")
    public Set<AIM> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Set<AIM> subscriptions) {
        this.subscriptions = subscriptions;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
