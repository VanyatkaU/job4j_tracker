package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sum = 0D;
        int lesson = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                lesson++;
            }
        }
        return sum / lesson;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> student = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0D;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            student.add(new Label(pupil.name(), sum / pupil.subjects().size()));
        }
        return student;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> less = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                less.computeIfPresent(subject.name(), (a, b) -> b + subject.score());
                less.putIfAbsent(subject.name(), subject.score());
            }
        }
        List<Label> lesson = new ArrayList<>();
        for (String name : less.keySet()) {
            lesson.add(new Label(name, less.get(name) / pupils.size()));
        }
        return lesson;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> student = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0D;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            student.add(new Label(pupil.name(), sum));
        }
        Collections.sort(student);
        return student.get(student.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> less = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                less.computeIfPresent(subject.name(), (a, b) -> b + subject.score());
                less.putIfAbsent(subject.name(), subject.score());
            }
        }
        List<Label> name = new ArrayList<>();
        for (String lesson : less.keySet()) {
            name.add(new Label(lesson, less.get(lesson)));
        }
        Collections.sort(name);
        return name.get(name.size() - 1);
    }
}
