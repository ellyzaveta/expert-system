package com.ai.expertsystem.services;

import com.ai.expertsystem.models.QuestionType;
import com.ai.expertsystem.models.nodes.AnswerNode;
import com.ai.expertsystem.models.nodes.QuestionNode;

import java.util.List;

public class TreeBuilderService {

    public QuestionNode constructASubtree() {

        AnswerNode node1 = new AnswerNode("Прозорі", "Застуда");
        AnswerNode node2 = new AnswerNode("Кольорові", "Синусит");

        return new QuestionNode("Які виділення з носа спостерігаються?", List.of(node1, node2), QuestionType.LIST);
    }

    public QuestionNode constructBSubtree() {
        AnswerNode node1 = new AnswerNode("Так", constructASubtree());
        AnswerNode node2 = new AnswerNode("Ні", "Вірусні інфекції");

        return new QuestionNode("Чи присутня закладеність носа?", List.of(node1, node2), QuestionType.YES_NO);
    }

    public QuestionNode constructCSubtree() {
        AnswerNode node1 = new AnswerNode("Жовте, зелене", "Пневмонія");
        AnswerNode node2 = new AnswerNode("Кров'яне", "Туберкульоз");
        AnswerNode node3 = new AnswerNode("Прозоре", "Бронхіт");

        return new QuestionNode("Яке мокротиння спостерігається?", List.of(node1, node2, node3), QuestionType.LIST);
    }

    public QuestionNode constructDSubtree() {
        AnswerNode node1 = new AnswerNode("Втрата смаку/запаху", "Ковід");
        AnswerNode node2 = new AnswerNode("Лихоманка", constructBSubtree());

        return new QuestionNode("Виберіть притаманний вам симптом зі списку", List.of(node1, node2), QuestionType.LIST);
    }

    public QuestionNode constructESubtree() {
        AnswerNode node1 = new AnswerNode("Сухий", constructDSubtree());
        AnswerNode node2 = new AnswerNode("З мокротинням", constructCSubtree());

        return new QuestionNode("Який тип кашлю спостерігається?", List.of(node1, node2), QuestionType.LIST);
    }

    public QuestionNode constructFSubtree() {
        AnswerNode node1 = new AnswerNode("Так", constructCSubtree());
        AnswerNode node2 = new AnswerNode("Ні", "Плеврит");

        return new QuestionNode("Кашель з мокротинням присутній?", List.of(node1, node2), QuestionType.YES_NO);
    }

    public QuestionNode constructGSubtree() {
        AnswerNode node1 = new AnswerNode("Біль у грудях", constructFSubtree());
        AnswerNode node2 = new AnswerNode("Напади задишок, свист у горлі", "Астма");
        AnswerNode node3 = new AnswerNode("Часті респіраторні інфекції", "Хронічне обструктивне захворювання легень");

        return new QuestionNode("Оберіть притаманний вам симптом зі списку", List.of(node1, node2, node3), QuestionType.LIST);

    }

    public QuestionNode constructHSubtree() {
        AnswerNode node1 = new AnswerNode("Так", "Ларингіт");
        AnswerNode node2 = new AnswerNode("Ні", constructGSubtree());

        return new QuestionNode("Чи присутні у вас голосові зміни?", List.of(node1, node2), QuestionType.YES_NO);
    }

    public QuestionNode constructISubtree() {
        AnswerNode node1 = new AnswerNode("0-2 тижні", constructESubtree());
        AnswerNode node2 = new AnswerNode(">2 тижнів", constructHSubtree());

        return new QuestionNode("Скільки продовжується кашель?", List.of(node1, node2), QuestionType.NUMBER);
    }

    public QuestionNode constructJSubtree() {
        AnswerNode node1 = new AnswerNode("Так", "Ангіна");
        AnswerNode node2 = new AnswerNode("Ні", "Мононуклеоз");

        return new QuestionNode("Чи наявні набряклі мигдалини?", List.of(node1, node2), QuestionType.YES_NO);
    }

    public QuestionNode constructKSubtree() {
        AnswerNode node1 = new AnswerNode("Так", constructJSubtree());
        AnswerNode node2 = new AnswerNode("Ні", "Запалення язика чи горла через вірусні інфекції");

        return new QuestionNode("Чи наявні збільшені лімфовузли?", List.of(node1, node2), QuestionType.YES_NO);
    }

    public QuestionNode constructLSubtree() {
        AnswerNode node1 = new AnswerNode("Ні", constructKSubtree());
        AnswerNode node2 = new AnswerNode("Так", constructISubtree());

        return new QuestionNode("Кашель присутній?", List.of(node1, node2), QuestionType.YES_NO);
    }

    public QuestionNode constructMSubtree() {
        AnswerNode node1 = new AnswerNode("Ні", constructBSubtree());
        AnswerNode node2 = new AnswerNode("Так", constructLSubtree());

        return new QuestionNode("Біль у горлі присутній?", List.of(node1, node2), QuestionType.YES_NO);
    }

    public QuestionNode constructNSubtree() {
        AnswerNode node1 = new AnswerNode("Лихоманка", constructMSubtree());
        AnswerNode node2 = new AnswerNode("Кашель", constructISubtree());
        AnswerNode node3 = new AnswerNode("Затруднене дихання", constructGSubtree());

        return new QuestionNode("Який основний симптом у вас спостерігається?", List.of(node1, node2, node3), QuestionType.LIST);
    }

    public QuestionNode buildTree() {
        return constructNSubtree();
    }
}
