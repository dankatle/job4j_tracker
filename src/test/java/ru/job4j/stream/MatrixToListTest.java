package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixToListTest {
    @Test
    public void matrixToList() {
        Integer[][] arr = {{1, 2, 3}, {4, 5, 6}};
        List<Integer> list = MatrixToList.matrixToList(arr);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        assertThat(expected, is(list));
    }
}