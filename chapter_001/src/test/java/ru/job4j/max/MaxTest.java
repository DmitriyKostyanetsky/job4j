package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *@author Dmitriy Kostyanetsky (onlywarinfarfuture@gmail.com)
 *@version 1
 *@since 23.03.18
 */

public class MaxTest {
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenSecondLessFirst() {
        Max maxim = new Max();
        int result = maxim.max(5, 2);
        assertThat(result, is(5));
    }

    @Test
    public void whenFirstEquallySecond() {
        Max maxim = new Max();
        int result = maxim.max(4, 4);
        assertThat(result, is(4));
    }

    @Test
    public  void whenFirstLessSecondAndThird() {
        Max maxim = new Max();
        int result = maxim.max(1, 3, 4);
        assertThat(result, is(4));
    }

    @Test
    public  void whenSecondLessFirstAndThird() {
        Max maxim = new Max();
        int result = maxim.max(7, 1, 2);
        assertThat(result, is(7));
    }

    @Test
    public void whenThirdLessFirstAndSecond() {
        Max maxim = new Max();
        int result = maxim.max(7, 10, 2);
        assertThat(result, is(10));
    }

    @Test
    public void whenFirstEquallySecondAndThird() {
        Max maxim = new Max();
        int result = maxim.max(2, 2, 2);
        assertThat(result, is(2));
    }
}