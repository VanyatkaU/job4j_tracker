package ru.job4j.oop;

public class Engineer extends Profession {
    private final String branch;

    public Engineer(String name, String surname,
                    String education, int birthday, String branch) {
        super(name, surname, education, birthday);
        this.branch = branch;
    }

    public String getBranch() {
        return branch;
    }
}
