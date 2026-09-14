package com.example.demo.service;


import com.example.demo.entity.Quest;
import com.example.demo.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestService {

    public List<Quest> getAllQuest(){
        return QuestRepository.findAll(); }


    @Autowired
    private QuestRepository QuestRepository;

    public Quest findById(int id){
        return QuestRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No quest found with this id" + id));
    }

    public List<Quest> createQuest(){
        return null;
    }
}

