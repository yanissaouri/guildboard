package com.example.demo.service;


import com.example.demo.entity.Quest;
import com.example.demo.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestService {

    public List<Quest> getAllQuests(){
        return QuestRepository.findAll();
    }

    @Autowired
    private QuestRepository QuestRepository;

    public Quest findById(int id){
        return QuestRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No Quest found with this id " + id));
    }

    public Quest createQuest(Quest Quest){
        return QuestRepository.save(Quest);
    }

    public Quest updateQuest(int id, Quest Quest){
        Quest existingQuest = QuestRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No Quest found with this id " + id));
        existingQuest.setTitle(Quest.getTitle());
        existingQuest.setDifficulty(Quest.getdifficulty());
        existingQuest.setGoldreward(Quest.getGoldreward());
        existingQuest.setXpreward(Quest.getXpreward());
        existingQuest.setLevel(Quest.getRequiredLevel());
        return QuestRepository.save(existingQuest);
    }

    public Quest deleteQuest(int id){
        Quest existingQuest = QuestRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No Quest found with this id " + id));
        QuestRepository.delete(existingQuest);
        return existingQuest;
    }
}