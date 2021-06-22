package ru.job4j.tracker;

import java.util.Arrays;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.add(new Item("Задача"));
        System.out.println(Arrays.toString(tracker.findByName("Задача")));

        Item item = new Item(1, "Go to the park");
        System.out.println(item);
    }
}
