package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] r = o1.split("/");
        String[] l = o2.split("/");
        int rsl = r[0].compareTo(l[0]);
        return rsl == 0 ? o1.compareTo(o2) : rsl;
    }
}
