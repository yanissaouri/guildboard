package com.example.demo.controller;

import com.example.demo.entity.Assignment;
import com.example.demo.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AssignmentController {

    private final AssignmentService assignmentService;

    @Autowired
    public AssignmentController(AssignmentService assignmentService){
        this.assignmentService = assignmentService;
    }

    @GetMapping("/api/adventurers/{id}/history")
    public List<Assignment> getAdventurerHistory(@PathVariable int id){

    }
}
