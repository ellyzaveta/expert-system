package com.ai.expertsystem.models.nodes;

import com.ai.expertsystem.models.QuestionType;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public record QuestionNode(String question, List<AnswerNode> answers, QuestionType questionType) {

    public QuestionNode {
        answers = Collections.unmodifiableList(answers);
    }

    public QuestionDTO getDTO() {
        List<String> textAnswers = answers.stream()
                .map(AnswerNode::answer)
                .collect(Collectors.toList());
        return new QuestionDTO(questionType, question, textAnswers);
    }
}
