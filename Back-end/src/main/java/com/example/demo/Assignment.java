package com.example.demo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Null;
import jdk.jfr.Timestamp;

import java.time.LocalDateTime;

@Entity
public class Assignment {

    public Assignment(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adventurer_id", nullable = false)
    private Adventurer adventurer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quest_id", nullable = false)
    private Quest quest;

    @Column(name = "assignedAt")
    private LocalDateTime assignedAt = LocalDateTime.now();

    @Column(name = "completedAt", nullable = true)
    private LocalDateTime completedAt;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public Adventurer getAdventurer() {
        return adventurer;
    }

    public void setAdventurer(Adventurer adventurer){
        this.adventurer = adventurer;
    }

    public Quest getQuest(){
        return quest;
    }

    public void setQuest(Quest quest){
        this.quest = quest;
    }

    public LocalDateTime getAssignedAt(){
        return assignedAt;
    }

    public void setAssignedAt(LocalDateTime assignedAt){
        this.assignedAt = assignedAt;
    }

    public LocalDateTime getCompletedAt(){
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt){
        this.completedAt = completedAt;
    }
}


