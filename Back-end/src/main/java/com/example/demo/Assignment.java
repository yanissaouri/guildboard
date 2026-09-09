package com.example.demo;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;

@Entity
public class Assignment {

    public Assignment(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    

    @Timestamp
    private int assignedAt;

    @Timestamp
    private int completedAt;


}


