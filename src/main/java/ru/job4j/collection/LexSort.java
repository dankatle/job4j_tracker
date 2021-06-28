package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] lStr = left.split("\\D+");
        String[] rStr = right.split("\\D+");
        int l = Integer.parseInt(lStr[0]);
        int r = Integer.parseInt(rStr[0]);
        return Integer.compare(l, r);
    }
}