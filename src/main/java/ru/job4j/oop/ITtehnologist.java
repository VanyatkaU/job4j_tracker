package ru.job4j.oop;

public class ITtehnologist extends Engineer {
    private final String project;

    public ITtehnologist(String name, String surname, String education,
                        int birthday, String brunch, String project) {
        super(name, surname, education, birthday, brunch);
        this.project = project;
    }

    public String getProject() {
        return project;
    }
}
