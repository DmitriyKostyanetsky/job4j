package exception;

public class ExceptionsExample {

    public void catchExceptions(int parameter) throws Exception {
        if (parameter == 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (parameter == 2) {
            throw new IndexOutOfBoundsException();
        }
        if (parameter == 3) {
            throw new ArithmeticException();
        }
        if (parameter == 4) {
            throw new RuntimeException();
        }
        if (parameter == 5) {
            throw new Exception();
        }
    }
}