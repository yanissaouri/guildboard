package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Adventurer;

public interface AdventurerRepository extends JpaRepository<Adventurer, Integer> {
}
