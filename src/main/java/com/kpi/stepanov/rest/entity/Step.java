package com.kpi.stepanov.rest.entity;

import javax.persistence.*;

@Entity
@Table(name = "steps")
public class Step {
    private Long id;
    private int sequenceNumber;
    private String description;
    private boolean completed;
    private AIM aim;

    public Step() {
    }

    public Step(int sequenceNumber, String description, AIM aim) {
        this.sequenceNumber = sequenceNumber;
        this.description = description;
        this.aim = aim;
    }

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "sequence_number", nullable = false)
    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    @Column(nullable = false, length = 84)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aim_id")
    public AIM getAim() {
        return aim;
    }

    public void setAim(AIM aim) {
        this.aim = aim;
    }
}
