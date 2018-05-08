package ru.job4j;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CoffeeTest {
    @Test
    public void whenValue100AndPrice35ThenSurrender65() {
        Coffee coffee = new Coffee();
        ArrayList<Integer> result = coffee.changes(100, 35);
        List<Integer> except = Arrays.asList(
                10, 10, 10, 10, 10, 10, 5
        );
        assertThat(result, is(except));
    }

    @Test
    public void whenValue46AndPrice45ThenSurrender1() {
        Coffee coffee = new Coffee();
        ArrayList<Integer> result = coffee.changes(46, 45);
        List<Integer> except = Arrays.asList(1);
        assertThat(result, is(except));
    }

    @Test
    public void whenValue100AndPrice61ThenSurrender39() {
        Coffee coffee = new Coffee();
        ArrayList<Integer> result = coffee.changes(100, 61);
        List<Integer> except = Arrays.asList(
                10, 10, 10, 5, 2, 2
        );
        assertThat(result, is(except));
    }
}