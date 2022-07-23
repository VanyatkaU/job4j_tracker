package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sum = 0d;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                count++;
            }
        }
        return sum / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0d;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            rsl.add(new Label(pupil.name(), sum / pupil.subjects().size()));
        }
        return rsl;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> subj = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subj.computeIfPresent(subject.name(), (a, b) -> b + subject.score());
                subj.putIfAbsent(subject.name(), subject.score());
            }
        }
        List<Label> rsl = new ArrayList<>();
        for (String sub : subj.keySet()) {
            rsl.add(new Label(sub, subj.get(sub) / pupils.size()));
        }
        return rsl;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0d;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            rsl.add(new Label(pupil.name(), sum));
        }
        Collections.sort(rsl);
        return rsl.get(rsl.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> subj = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subj.computeIfPresent(subject.name(), (a, b) -> b + subject.score());
                subj.putIfAbsent(subject.name(), subject.score());
            }
        }
        List<Label> rsl = new ArrayList<>();
        for (String sub : subj.keySet()) {
            rsl.add(new Label(sub, subj.get(sub)));
        }
        Collections.sort(rsl);
        return rsl.get(rsl.size() - 1);
    }
}
