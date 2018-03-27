package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {
    @Test
    public void whenArrayHasLengh5Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }
    @Test
    public void whenArrayMinusOne() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{23, 32, 2, 5, 0};
        int value = 1;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }
    @Test
    public void whenArrayHasLength2Then4() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{42, 23, 9, 5, 2};
        int value = 2;
        int result = find.indexOf(input, value);
        int expect = 4;
        assertThat(result, is(expect));
    }
}