package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        for (int i = 0; i < Math.min(left.length(), right.length()); i++) {
            int l = left.charAt(i);
            int r = right.charAt(i);
            if (l != r) {
               return l - r;
           }
        }
        return Integer.compare(left.length(), right.length());
    }
}
