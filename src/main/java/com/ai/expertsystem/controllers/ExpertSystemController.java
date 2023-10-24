package com.ai.expertsystem.controllers;

import com.ai.expertsystem.models.QuestionType;
import com.ai.expertsystem.models.nodes.AnswerNode;
import com.ai.expertsystem.models.nodes.QuestionDTO;
import com.ai.expertsystem.models.nodes.QuestionNode;
import com.ai.expertsystem.services.DiseaseStatisticsService;
import com.ai.expertsystem.services.TreeBuilderService;

import java.util.Map;

public class ExpertSystemController {

    private final TreeBuilderService treeBuilder = new TreeBuilderService();
    private final DiseaseStatisticsService diseaseStatistics = new DiseaseStatisticsService();
    private QuestionNode currentQuestion = treeBuilder.buildTree();

    public QuestionDTO getCurrentQuestion() {
        return currentQuestion.getDTO();
    }

    public Map<String, Double> getResult() {
        return diseaseStatistics.getResult();
    }

    public QuestionDTO getNextQuestion(int index) {

        AnswerNode selectedAnswer = null;

        if (currentQuestion.questionType() == QuestionType.NUMBER) {
            if (index >= 0 && index <= 2) {
                selectedAnswer = currentQuestion.answers().get(0);
            } else {
                selectedAnswer = currentQuestion.answers().get(1);
            }
        } else if (index <= currentQuestion.answers().size()) {
            selectedAnswer = currentQuestion.answers().get(index);
        }

        if (selectedAnswer != null) {
            diseaseStatistics.setPoints(selectedAnswer.disease());
            currentQuestion = selectedAnswer.questionNode();
        }

        if (currentQuestion == null) {
            return null;
        } else {
            return currentQuestion.getDTO();
        }
    }
}
