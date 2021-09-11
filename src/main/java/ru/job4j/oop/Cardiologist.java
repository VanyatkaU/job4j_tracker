package ru.job4j.oop;

public class Cardiologist extends Doctor {
    private final String examination;

    public Cardiologist(String name, String surname, String education,
                            int birthday, String brunch, String examination) {
        super(name, surname, education, birthday, brunch);
        this.examination = examination;
        }

    public String getExamination() {
        return examination;
    }
}
