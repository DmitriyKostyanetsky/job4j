package exception;

public class TestForExceptions extends Exception {

    public void myFunc(int number) throws RuntimeException {
        if (number == 0) {
            System.out.println("ArithmeticException handling!");
        }
        if (number == 1) {
            System.out.println("ArrayIndexOutOfBoundsException handling!");
        }
        if (number == 2) {
            System.out.println("IndexOutOfBoundsException handling!");
        }
    }
}