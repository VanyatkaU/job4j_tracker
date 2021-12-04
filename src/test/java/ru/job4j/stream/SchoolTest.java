package ru.job4j.stream;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    @Test
    public void whenCollect() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(40, "Surname4"),
                new Student(50, "Surname5"),
                new Student(70, "Surname7"));
        School sc = new School();
        Map<String, Student> rsl = sc.collect(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Surname1", new Student(10, "Surname1"));
        expected.put("Surname4", new Student(40, "Surname4"));
        expected.put("Surname5", new Student(50, "Surname5"));
        expected.put("Surname7", new Student(70, "Surname7"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectRep() {
        List<Student> students = List.of(
                new Student(20, "Surname2"),
                new Student(30, "Surname3"),
                new Student(30, "Surname3"),
                new Student(80, "Surname8"),
                new Student(80, "Surname8")
        );
        School sc = new School();
        Map<String, Student> rsl = sc.collect(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Surname2", new Student(20, "Surname2"));
        expected.put("Surname3", new Student(30, "Surname3"));
        expected.put("Surname8", new Student(80, "Surname8"));
        assertThat(rsl, is(expected));
    }
}
