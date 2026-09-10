package com.example.demo.service;


import com.example.demo.entity.Adventurer;
import com.example.demo.repository.AdventurerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdventurerService {

    public List<Adventurer> getAllAdventurers(){
        return adventurerRepository.findAll();
    }

    @Autowired
    private AdventurerRepository adventurerRepository;

    public Adventurer findById(int id){
        return adventurerRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No adventurer found with this id" + id));
    }

    public List<Adventurer> createAdventurer(){
        return null;
    }
}
