package com.ai.expertsystem.services;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.entry;

public class DiseaseStatisticsService {

    private final Map<String, Integer> diseaseMap = new HashMap<>(
            Map.ofEntries(
                    entry("Астма", 0),
                    entry("Хронічне обструктивне захворювання легень", 0),
                    entry("Вірусні інфекції", 0),
                    entry("Ларингіт", 0),
                    entry("Плеврит", 0),
                    entry("Застуда", 0),
                    entry("Синусит", 0),
                    entry("Запалення язика чи горла через вірусні інфекції", 0),
                    entry("Ковід", 0),
                    entry("Пневмонія", 0),
                    entry("Туберкульоз", 0),
                    entry("Бронхіт", 0),
                    entry("Ангіна", 0),
                    entry("Мононуклеоз", 0)
            )
    );

    public void setPoints(List<String> diseaseList) {
        for (Map.Entry<String, Integer> entry : diseaseMap.entrySet()) {
            String key = entry.getKey();

            for(String diseaseToAdd : diseaseList) {
                if(Objects.equals(key, diseaseToAdd)) {
                    Integer value = entry.getValue();
                    value = value + 1;
                    entry.setValue(value);
                }
            }
        }
    }

    public Map<String, Double> getResult() {
        Map<String, Integer> top3 = diseaseMap.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .limit(3)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));

        top3.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(entry -> top3.put(entry.getKey(), entry.getValue() + 5));

        double sum = top3.values().stream().mapToInt(Integer::intValue).sum();

        return top3.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> {
                            double percentage = ((double) entry.getValue() / sum) * 100;
                            return Math.round(percentage * 100.0) / 100.0;
                        },
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
    }
}
