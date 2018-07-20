package exception;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ExceptionExampleTest {

    private ExceptionsExample example;
    private int[] array;
    private int number;

    @Test
    public void whenDivideByZeroThenArithmeticException() throws Exception {
        array = new int[] {1, 2};
        number = 0;
        example = new ExceptionsExample(array, number);
        int result = example.catchExceptions(array, number);
        assertEquals(result, 0);
    }

    @Test
    public void whenDivideByNothingThenOutOfBounds() throws Exception {
        array = new int[] {1};
        number = 1;
        example = new ExceptionsExample(array, number);
        int result = example.catchExceptions(array, number);
        assertNotEquals(result, 1);
    }

    @Test
    public void whenDivideBy1Then2() throws Exception {
        array = new int[] {1, 2};
        number = 1;
        example = new ExceptionsExample(array, number);
        int result = example.catchExceptions(array, number);
        assertThat(result, is(2));
    }
}