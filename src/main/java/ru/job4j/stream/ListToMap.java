package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {
    public static Map<Student, String> listToMap(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(
                        x -> x,
                        Student::getSurname
                ));
    }
}
