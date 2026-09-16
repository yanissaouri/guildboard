package com.example.demo.controller;

import com.example.demo.entity.Assignment;
import com.example.demo.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class AssignmentController {

    private final AssignmentService assignmentService;

    @Autowired
    public AssignmentController(AssignmentService assignmentService){
        this.assignmentService = assignmentService;
    }

    @GetMapping("/api/adventurers/{id}/history")
    public List<Assignment> getAdventurerHistory(@PathVariable int id){
    return null;
    }

    @PostMapping("/api/quests/{id}/assignment")
    public ResponseEntity<Assignment> assignQuestToAdventurer(@PathVariable("id") int questId,
                                                              @RequestBody Map <String, Integer> body){
        int adventurerId = body.get("adventurerId");
        Assignment assignment = assignmentService.assignQuestToAdventurer(questId, adventurerId);
        return ResponseEntity.status(HttpStatus.CREATED).body(assignment);
    }
}
