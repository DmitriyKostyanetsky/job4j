package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {
    @Test
    public void whenSize9ThenTable2To2() {
        Matrix matrix = new Matrix();
        int input = 2;
        int[][] result = matrix.multiple(input);
        int[][] except = {{1, 2}, {2, 4}};
        assertThat(result, is(except));
    }
    @Test
    public void whenSize5ThenTable5To5() {
        Matrix matrix = new Matrix();
        int input = 5;
        int[][] result = matrix.multiple(input);
        int[][] except = {
                            {1, 2, 3, 4, 5},
                            {2, 4, 6, 8, 10},
                            {3, 6, 9, 12, 15},
                            {4, 8, 12, 16, 20},
                            {5, 10, 15, 20, 25}
        };
        assertThat(result, is(except));
    }
}