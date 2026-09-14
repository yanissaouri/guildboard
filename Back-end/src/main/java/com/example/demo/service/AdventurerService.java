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
                () -> new RuntimeException("No adventurer found with this id " + id));
    }

    public Adventurer createAdventurer(Adventurer adventurer){
        return adventurerRepository.save(adventurer);
    }

    public Adventurer updateAdventurer(int id, Adventurer adventurer){
        Adventurer existingAdventurer = adventurerRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No adventurer found with this id " + id));
        existingAdventurer.setName(adventurer.getName());
        existingAdventurer.setCharacterClass(adventurer.getCharacterClass());
        existingAdventurer.setGold(adventurer.getGold());
        existingAdventurer.setXp(adventurer.getXp());
        existingAdventurer.setLevel(adventurer.getLevel());
        return adventurerRepository.save(existingAdventurer);
    }

    public Adventurer deleteAdventurer(int id){
        Adventurer existingAdventurer = adventurerRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No adventurer found with this id " + id));
        adventurerRepository.delete(existingAdventurer);
        return existingAdventurer;
    }
}
