package com.example.demo;


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
    private int requiredlevel = 1;
    private int xpreward = 1;

@Min(0)
private int goldreward = 0;

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
        return requiredlevel;
    }

    public void setLevel(int requiredlevel){
        this.requiredlevel = requiredlevel;
    }

    public int getXpreward(){
        return xpreward;
    }

    public void setXpreward(int xpreward){
        this.xpreward = xpreward;
    }

    public int getGoldreward(){
        return goldreward;
    }

    public void setGoldreward(int goldreward){
        this.goldreward = goldreward;
    }

    public Difficulty getdifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

}



