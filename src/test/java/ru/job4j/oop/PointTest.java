package ru.job4j.oop;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void distance3d() {
        Point point = new Point(1, 1, 0);
        Point point2 = new Point(2, 1, 2);
        double rsl = point.distance3d(point2);
        double expected = 2.24;
        assertEquals(rsl, expected, 0.01);
    }
}