package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ElementDeleteTest {
    @Test
    public void whenElementThreeThenDeleteThree() {
        ElementDelete ed = new ElementDelete();
        int[] inputArray = new int[] {1, 5, 2, 3, 9};
        int[] result = ed.remove(inputArray, 3);
        int[] except = new int[] {1, 5, 2, 9};
        assertThat(result, is(except));
    }

    @Test
    public void whenElementFiveThenDeleteFive() {
        ElementDelete ed = new ElementDelete();
        int[] inputArray = new int[] {1, 5, 2, 3, 9, 4};
        int[] result = ed.remove(inputArray, 5);
        int[] except = new int[] {1, 4, 2, 3, 9};
        assertThat(result, is(except));
    }
}