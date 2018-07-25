package exception;

import org.junit.Test;

public class ExceptionExampleTest {

    private ExceptionsExample example;

    @Test
    public void testException1()  {
        example = new ExceptionsExample();
        try {
            example.catchExceptions(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testException2()  {
        example = new ExceptionsExample();
        try {
            example.catchExceptions(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testException3()  {
        example = new ExceptionsExample();
        try {
            example.catchExceptions(4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}