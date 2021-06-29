package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] right = o1.split("/");
        String[] left = o2.split("/");
        int rsl = left[0].compareTo(right[0]);
        return rsl == 0 ? o1.compareTo(o2) : rsl;
    }
}
