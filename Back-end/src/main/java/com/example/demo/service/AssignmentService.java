package com.example.demo.service;

import com.example.demo.entity.Adventurer;
import com.example.demo.entity.Assignment;
import com.example.demo.entity.Quest;
import com.example.demo.entity.Status;
import com.example.demo.repository.AdventurerRepository;
import com.example.demo.repository.AssignmentRepository;
import com.example.demo.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

import java.util.List;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;
    @Autowired
    private AdventurerRepository adventurerRepository;
    @Autowired
    private QuestRepository questRepository;

    public List<Assignment> getAdventurerHistory(int id){
        Adventurer adventurer = adventurerRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No adventurer found with this id " + id));
        return assignmentRepository.findByAdventurer(adventurer);
    }

    public Assignment assignQuestToAdventurer(int questId, int adventurerId){
        Quest quest = questRepository.findById(questId).orElseThrow(
                () -> new RuntimeException("No quest found with this id " + questId));
        Adventurer adventurer = adventurerRepository.findById(adventurerId).orElseThrow(
                () -> new RuntimeException("No adventurer found with this id " + adventurerId));

        if (adventurer.getLevel() >= quest.getRequiredLevel()){
            List<Assignment> activeAssignments = assignmentRepository.findByAdventurerAndCompletedAtIsNull(adventurer);
            if (!activeAssignments.isEmpty()){
                throw new RuntimeException("This adventurer already has a quest in progress.");
            }
        }
        else{
            throw new RuntimeException("Adventurer level's too low.");
        }
        Assignment assignment = new Assignment();
        assignment.setAdventurer(adventurer);
        assignment.setQuest(quest);
        return assignmentRepository.save(assignment);

    }

    public completedAssignment(int assignmentId){
        Assignment assignment = assignmentRepository.findById(assignmentId).orElseThrow(
                () -> new RuntimeException("No assignment found with this id " + assignmentId));
        Adventurer adventurer = assignment.getAdventurer();
        Quest quest = assignment.getQuest();
        adventurer.setGold(adventurer.getGold() + quest.getGoldReward());
        adventurer.setXp(adventurer.getXp() + quest.getXpReward());

        while (adventurer.getXp() >= adventurer.getLevel() * 100){
            adventurer.setXp(adventurer.getXp() - adventurer.getLevel() * 100);
            adventurer.setLevel(adventurer.getLevel() + 1);
        }
        assignment.setCompletedAt(LocalDateTime.now());
        quest.setStatus(Status.COMPLETED);
        adventurerRepository.save(adventurer);
        assignmentRepository.save(assignment);
        return assignment;
    }

}
