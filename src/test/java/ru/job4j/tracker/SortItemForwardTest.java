package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortItemForwardTest {
    @Test
    public void sortBack() {
        Item item = new Item("Masha");
        Item item2 = new Item("Sasha");
        Item item3 = new Item("Alexandr");
        Item item4 = new Item("Daniil");
        List<Item> list = Arrays.asList(item, item2,
                item3, item4);
        list.sort(new SortItemForward());
        List<Item> expected = Arrays.asList(item3, item4,
                item, item2);
        assertThat(list, is(expected));
    }
}