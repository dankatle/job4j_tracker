package ru.job4j.stream;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ListToMapTest {
    @Test
    public void listToMap() {
        Student student = new Student(4, "Иванова");
        Student student2 = new Student(3, "Макарова");
        Student student3 = new Student(2, "Макарова");
        Student student4 = new Student(5, "Ильченко");
        List<Student> students = List.of(
                student,
                student2,
                student3,
                student4
        );
        Map<String, Student> map = ListToMap.listToMap(students);
        Map<String, Student> expected = Map.of(
                student.getSurname(), student,
                student2.getSurname(), student2,
                student4.getSurname(), student4
        );
        assertThat(expected, is(map));
    }
}