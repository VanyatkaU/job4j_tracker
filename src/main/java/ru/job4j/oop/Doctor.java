package ru.job4j.oop;

public class Doctor extends Profession {
    private final String direction;

    public Doctor(String name, String surname,
                  String education, int birthday, String direction) {
        super(name, surname, education, birthday);
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }
}
