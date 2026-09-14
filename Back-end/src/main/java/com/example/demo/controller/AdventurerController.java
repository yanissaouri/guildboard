package com.example.demo.controller;


import com.example.demo.entity.Adventurer;
import com.example.demo.service.AdventurerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("/api/adventurers")
    public ResponseEntity<Adventurer> createAdventurer(@RequestBody Adventurer adventurer){
        Adventurer savedAdventurer = adventurerService.createAdventurer(adventurer);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAdventurer);
    }

    @PutMapping("/api/adventurers/{id}")
    public ResponseEntity<Adventurer> updateAdventurer(@PathVariable int id,
                                                       @RequestBody Adventurer adventurer){
        Adventurer updatedAdventurer = adventurerService.updateAdventurer(id, adventurer);
        return ResponseEntity.status(HttpStatus.OK).body(updatedAdventurer);
    }

    @DeleteMapping("/api/adventurers/{id}")
    public ResponseEntity<Adventurer> deleteAdventurer(@PathVariable int id){
        
        Adventurer removedAdventurer = adventurerService.deleteAdventurer(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(removedAdventurer);
    }





}
