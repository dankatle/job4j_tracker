package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI {
    public static void main(String[] args) {
        List<Integer> list = List.of(-41, 2, 43, -512, 35, 39, 576);
        List<Integer> filterList = list.stream()
                .filter(x -> x > 0)
                .collect(Collectors.toList());
        filterList.forEach(System.out::println);
    }
}
