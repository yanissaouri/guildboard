package com.example.demo.controller;



import com.example.demo.entity.Quest;
import com.example.demo.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestController {

    private final QuestService questService;

    @Autowired
    public QuestController(QuestService questService){
        this.questService = questService;
    }

    @GetMapping("/api/quests")
    public List<Quest> getQuests(){
        return questService.getAllQuests();
    }

    @GetMapping("/api/quests/{id}")
    public ResponseEntity<Quest> getQuestById(@PathVariable int id){
        Quest quest = questService.findById(id);
        if (quest != null){
            return ResponseEntity.ok(quest);
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping("/api/quests")
    public ResponseEntity<Quest> createQuest(@RequestBody Quest quest){
        Quest savedQuest = questService.createQuest(quest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedQuest);
    }

    @PutMapping("/api/quests/{id}")
    public ResponseEntity<Quest> updateQuest(@PathVariable int id,
                                                       @RequestBody Quest quest){
        Quest updatedQuest = questService.updateQuest(id, quest);
        return ResponseEntity.status(HttpStatus.OK).body(updatedQuest);
    }

    @DeleteMapping("/api/quests/{id}")
    public ResponseEntity<Quest> deleteQuest(@PathVariable int id){

        Quest removedQuest = questService.deleteQuest(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(removedQuest);
    }

    @PostMapping("/api/quests/{id}/assignment")
    public ResponseEntity<Quest> assignQuest(@PathVariable int adventurer_id){

        Quest assignQuest = questService.assignQuest(adventurer_id);
        return ResponseEntity.status(HttpStatus. NO_CONTENT).body(assignQuest);
    }

    







}
