package com.kpi.stepanov.rest.entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "aims")
public class AIM {
    private Long id;
    private String title;
    private String description;
    private boolean completed;
    private boolean common;
    private Date creationDate;
    private Set<Step> steps;
    private Set<User> subscribers;
    private User creator;

    public AIM() {
    }

    public AIM(String title, String description, boolean common, User creator) {
        this.title = title;
        this.description = description;
        this.common = common;
        this.creationDate = Calendar.getInstance().getTime();
        this.creator = creator;
    }

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false, length = 84)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(nullable = false, length = 400)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(nullable = false)
    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Column(nullable = false)
    public boolean isCommon() {
        return common;
    }

    public void setCommon(boolean common) {
        this.common = common;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "creation_date", nullable = false)
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @OneToMany(mappedBy="aim", cascade = CascadeType.ALL)
    public Set<Step> getSteps() {
        return steps;
    }

    public void setSteps(Set<Step> steps) {
        this.steps = steps;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "subscriptions",
            joinColumns = { @JoinColumn(name = "aim_id", referencedColumnName="id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "user_id", referencedColumnName="id", nullable = false, updatable = false) })
    public Set<User> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Set<User> subscribers) {
        this.subscribers = subscribers;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }


}
