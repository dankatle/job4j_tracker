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
        Map<Student, String> map = ListToMap.listToMap(students);
        Map<Student, String> expected = Map.of(
                student, student.getSurname(),
                student2, student2.getSurname(),
                student3, student3.getSurname(),
                student4, student4.getSurname()
        );
        assertThat(expected, is(map));
    }
}