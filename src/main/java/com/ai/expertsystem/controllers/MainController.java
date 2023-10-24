package com.ai.expertsystem.controllers;

import com.ai.expertsystem.models.nodes.QuestionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/expertSystem/")
public class MainController {

    private ExpertSystemController expertSystem = new ExpertSystemController();

    @GetMapping("/currentQuestion")
    public QuestionDTO getQuestion() {
        return expertSystem.getCurrentQuestion();
    }

    @PostMapping("/nextQuestion")
    public ResponseEntity<Object> getNextQuestion(@RequestParam int index) {
        QuestionDTO questionDTO = expertSystem.getNextQuestion(index);
        return ResponseEntity.ok(questionDTO);
    }

    @GetMapping("/result")
    public Map<String, Double> getResult() {
        return expertSystem.getResult();
    }

    @GetMapping("/newTree")
    public ResponseEntity<QuestionDTO> newTree() {
        expertSystem = new ExpertSystemController();
        QuestionDTO questionDTO = expertSystem.getCurrentQuestion();
        return ResponseEntity.ok(questionDTO);
    }

}
