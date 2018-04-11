package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortThreeTest {
    @Test
    public void whenTwoArraysThenSortTheirInThirdArray() {
        int[] oneArray = new int[] {1, 3};
        int[] secondArray = new int[] {2, 5};
        SortThree sort = new SortThree();
        int[] except = new int[] {1, 2, 3, 5};
        int[] result = sort.newThirdArray(oneArray, secondArray);
        assertThat(result, is(except));
    }

    @Test
    public void whenTwoArraysThenSortTheirInThirdArraySecondTest() {
        int[] oneArray = new int[] {1, 3, 6, 7};
        int[] secondArray = new int[] {5};
        SortThree sort = new SortThree();
        int[] except = new int[] {1, 3, 5, 6, 7};
        int[] result = sort.newThirdArray(oneArray, secondArray);
        assertThat(result, is(except));
    }

    @Test
    public void whenTwoArraysThenSortTheirInThirdArrayThirdTest() {
        int[] oneArray = new int[] {0, 6, 23, 39};
        int[] secondArray = new int[] {1, 3, 15};
        SortThree sort = new SortThree();
        int[] except = new int[] {0, 1, 3, 6, 15, 23, 39};
        int[] result = sort.newThirdArray(oneArray, secondArray);
        assertThat(result, is(except));
    }
}