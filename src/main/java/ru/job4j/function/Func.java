package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Func {
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            list.add(func.apply((double) i));
        }
        return list;
    }

    public static void main(String[] args) {
        List<Double> result = Func.diapason(5, 8, x -> x * x);
        System.out.println(result);
    }
}
