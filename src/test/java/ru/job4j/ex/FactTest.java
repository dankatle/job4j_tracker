package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FactTest {
    @Test(expected = IllegalArgumentException.class)
    public void whenNisNegativeNumber() {
        new Fact().calc(-1);
    }

    @Test
    public void whenNisNotNegativeNumber() {
        int result = new Fact().calc(2);
        assertThat(result, is(2));
    }
}
