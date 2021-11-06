package ru.job4j.collection;

import java.util.Objects;

import static java.lang.Integer.compare;

public class User implements Comparable<User> {
    private final String name;
    private final int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return age == user.age && name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(User o) {
        int rsl = name.compareTo(o.name);
        if (rsl == 0) {
            rsl = compare(age, o.age);
        }
        return rsl;
    }
}
