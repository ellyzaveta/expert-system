package com.ai.expertsystem.models.nodes;

import java.util.ArrayList;
import java.util.List;

public record AnswerNode(String answer, List<String> disease, QuestionNode questionNode) {

    public AnswerNode(String answer, QuestionNode questionNode) {
        this(answer, collectDiseasesFrom(questionNode), questionNode);
    }

    public AnswerNode(String answer, String disease) {
        this(answer, List.of(disease), null);
    }

    private static List<String> collectDiseasesFrom(QuestionNode questionNode) {
        List<String> diseases = new ArrayList<>();
        for (AnswerNode answerNode : questionNode.answers()) {
            for (String diseaseItem : answerNode.disease()) {
                if (!diseases.contains(diseaseItem)) {
                    diseases.add(diseaseItem);
                }
            }
        }
        return diseases;
    }
}



