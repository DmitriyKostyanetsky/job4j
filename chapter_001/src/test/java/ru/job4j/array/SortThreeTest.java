package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortThreeTest {
    @Test
    public void whenTwoArraysThenSortTheirInThirdArray() {
        int[] oneArray = new int[] {3, 1};
        int[] secondArray = new int[] {5, 2};
        SortThree sort = new SortThree();
        int[] except = new int[] {1, 2, 3, 5};
        int[] result = sort.newThirdArray(oneArray, secondArray);
        sort.sortArray(result);
        assertThat(result, is(except));
    }

    @Test
    public void whenTwoArraysThenSortTheirInThirdArraySecondTest() {
        int[] oneArray = new int[] {3, 1, 6, 7};
        int[] secondArray = new int[] {5};
        SortThree sort = new SortThree();
        int[] except = new int[] {1, 3, 5, 6, 7};
        int[] result = sort.newThirdArray(oneArray, secondArray);
        sort.sortArray(result);
        assertThat(result, is(except));
    }

    @Test
    public void whenTwoArraysThenSortTheirInThirdArrayThirdTest() {
        int[] oneArray = new int[] {39, 56, 23, 6, 0};
        int[] secondArray = new int[] {82, 76, 2, 34, 78, 2, 7, 9};
        SortThree sort = new SortThree();
        int[] except = new int[] {0, 2, 2, 6, 7, 9, 23, 34, 39, 56, 76, 78, 82};
        int[] result = sort.newThirdArray(oneArray, secondArray);
        sort.sortArray(result);
        assertThat(result, is(except));
    }
}