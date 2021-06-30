package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixToList {
    public static List<Integer> matrixToList(Integer[][] arr) {
        Stream<Integer[]> matrix = Stream.of(arr);
        return matrix.flatMap(Stream::of)
                .collect(Collectors.toList());
    }
}
