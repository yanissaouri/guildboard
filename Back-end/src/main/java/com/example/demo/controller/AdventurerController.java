package com.example.demo.controller;


import com.example.demo.entity.Adventurer;
import com.example.demo.service.AdventurerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdventurerController {

    private final AdventurerService adventurerService;

    @Autowired
    public AdventurerController(AdventurerService adventurerService){
        this.adventurerService = adventurerService;
    }

    @GetMapping("/api/adventurers")
    public List<Adventurer> getAdventurers(){
        return adventurerService.getAllAdventurers();
    }

    @GetMapping("/api/adventurers/{id}")
    public ResponseEntity<Adventurer> getAdventurerById(@PathVariable int id){
        Adventurer adventurer = adventurerService.findById(id);
        if (adventurer != null){
            return ResponseEntity.ok(adventurer);
        }
        return ResponseEntity.notFound().build();
    }

}
