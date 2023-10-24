package com.ai.expertsystem.models.nodes;

import com.ai.expertsystem.models.QuestionType;

import java.util.List;

public record QuestionDTO(QuestionType questionType,
                          String questionText,
                          List<String> textAnswers) {}
