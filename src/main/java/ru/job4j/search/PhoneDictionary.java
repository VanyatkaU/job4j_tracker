package ru.job4j.search;

import ru.job4j.function.Predicate;

import java.util.ArrayList;

class PhoneDictionary {
    private final ArrayList<Person> persons = new ArrayList<>();

    void add(Person person) {
        this.persons.add(person);
    }

    ArrayList<Person> find(String key) {
        Predicate<Person> combine = person -> person.getName().contains(key)
                || person.getSurname().contains(key)
                || person.getPhone().contains(key)
                || person.getAddress().contains(key);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
