package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import  static org.junit.Assert.assertThat;

public class SquareTest {
    @Test
    public void whenBoundThreeThenOneFourNine() {
        int bound = 3;
        Square square = new Square();
        int[] result = square.calculate(bound);
        int[] expect = new int[] {1 , 4, 9};
        assertThat(result, is(expect));
    }
    @Test
    public void whenBoundFiveThenOneFourNineSixteenTwentyFive() {
        int bound = 5;
        Square square = new Square();
        int[] result = square.calculate(bound);
        int[] expect = new int[] {1, 4, 9, 16, 25};
        assertThat(result, is(expect));
    }
    @Test
    public void whenBoundOneThenOne() {
        int bound = 1;
        Square square = new Square();
        int[] result = square.calculate(bound);
        int[] expect = new int[] {1};
        assertThat(result, is(expect));
    }
}