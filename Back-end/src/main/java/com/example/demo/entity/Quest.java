package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity

public class Quest{
    public Quest(){

    }

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
    @Column(unique = true)
    @NotBlank
    @Size(min=2, max=50)
private String title;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @Min(1)
    private int requiredLevel = 1;
    private int xpReward = 1;

@Min(0)
private int goldReward = 0;

    @Enumerated(EnumType.STRING)
    private Status status;


    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public int getRequiredLevel(){
        return requiredLevel;
    }

    public void setRequiredLevel(int requiredLevel){
        this.requiredLevel = requiredLevel;
    }

    public int getXpReward(){
        return xpReward;
    }

    public void setXpReward(int xpReward){
        this.xpReward = xpReward;
    }

    public int getGoldReward(){
        return goldReward;
    }

    public void setGoldReward(int goldReward){
        this.goldReward = goldReward;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Status getStatus(){
        return status;
    }

    public  void setStatus(Status status){
        this.status = status;
    }

}



