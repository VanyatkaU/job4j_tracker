package ru.job4j.oop;

public class Metallurgist extends Engineer {
    private final String tp;

    public Metallurgist(String name, String surname, String education,
                        int birthday, String brunch, String tp) {
        super(name, surname, education, birthday, brunch);
        this.tp = tp;
    }

    public String getTp() {
        return tp;
    }
}
