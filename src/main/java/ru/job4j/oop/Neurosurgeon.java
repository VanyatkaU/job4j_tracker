package ru.job4j.oop;

public class Neurosurgeon extends Doctor {
    private final String operation;

    public Neurosurgeon(String name, String surname, String education,
                        int birthday, String brunch, String operation) {
        super(name, surname, education, birthday, brunch);
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}
