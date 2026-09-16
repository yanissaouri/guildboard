package com.example.demo.repository;

import com.example.demo.entity.Adventurer;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Assignment;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {
    List<Assignment> findByAdventurer(Adventurer adventurer);
    List<Assignment> findByAdventurerAndCompletedAtIsNull(Adventurer adventurer);
}
