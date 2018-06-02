package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {

    private final int[] values;
    private int index = -1;

    public EvenNumbersIterator(int[] values) {
        this.values = values;
        testNextNumber();
    }

    /**
     * Метод проверяет, что следующее число четное
     */
    private void testNextNumber() {
        index++;
        while (index < values.length && values[index] % 2 == 1) {
            index++;
        }
    }

    /**
     * Метод проверяет, имеются ли в массиве четные числа
     * @return возвращает true если четные числа остались, false если нет
     */
    private boolean checkForEven() {
        if (index == - 1) {
            index = 0;
        }
        for (int i = index; i < values.length; i++) {
            if (values[index] % 2 == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasNext() {
        return checkForEven();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int evenNumber = values[index];
        testNextNumber();
        return evenNumber;
    }
}