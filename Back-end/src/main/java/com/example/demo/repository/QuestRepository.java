package com.example.demo.repository;

import com.example.demo.entity.Assignment;
import com.example.demo.entity.Quest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestRepository extends JpaRepository<Quest, Integer> {
    List<Quest> findByQuestAndCompletedAtIsNull(Quest quest);
}
