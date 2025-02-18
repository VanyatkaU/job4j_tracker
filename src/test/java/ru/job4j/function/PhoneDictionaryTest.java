package ru.job4j.function;

import org.junit.Test;

import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void notFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Anton", "Ivanov", "462593", "Kursk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.size(), is(0));
    }
}
