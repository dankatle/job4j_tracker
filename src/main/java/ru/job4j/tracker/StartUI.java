package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.add(new Item("Задача"));
        System.out.println(Arrays.toString(tracker.findByName("Задача")));
    }
}
