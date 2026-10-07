package Homework.CollectionsLearn.Lessons;

import Homework.AfterLesson.OOP.WorkShop.Student;

import java.util.*;

class ResultsBoard {
    private TreeMap<Float, String> scores;

    public ResultsBoard() {
        scores = new TreeMap<>();
    }

    void addStudent(String name, Float score) {
        // Если есть студент с таким же баллом, добавляем имя через запятую
        String existingName = scores.get(score);
        if (existingName != null) {
            scores.put(score, existingName + ", " + name);
        } else {
            scores.put(score, name);
        }
    }

    List<String> top3() {
        List<String> topStudents = new ArrayList<>();

        for (Map.Entry<Float, String> entry : scores.descendingMap().entrySet()) {
            String[] names = entry.getValue().split(", ");
            for (String name : names) {
                topStudents.add(name);
                if (topStudents.size() >= 3) {
                    return topStudents;
                }
            }
        }

        return topStudents;
    }
}
