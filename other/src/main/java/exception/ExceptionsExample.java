package exception;

public class ExceptionsExample {

    private int[] array;
    private int number;
    private TestForExceptions test;

    public ExceptionsExample(int[] array, int number) {
        this.array = array;
        this.number = number;
        test = new TestForExceptions();
    }

    public int catchExceptions(int[] array, int number) throws Exception {
        int result = 0;
        try {
            result = array[1] / number;
        } catch (ArrayIndexOutOfBoundsException e) {
            test.myFunc(1);
        } catch (IndexOutOfBoundsException e) {
            test.myFunc(2);
        }catch (ArithmeticException e) {
            test.myFunc(0);
        } catch (RuntimeException e) {
            System.out.println("RuntimeException handling!");
        } catch (Exception e) {
            throw new Exception();
        }
        return result;
    }
}