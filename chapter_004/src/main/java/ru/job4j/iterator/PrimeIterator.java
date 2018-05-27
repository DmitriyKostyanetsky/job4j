package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrimeIterator implements Iterator<Integer> {
    private int[] values;
    private int index = -1;

    public PrimeIterator(int[] values) {
        this.values = values;
    }

    /**
     * Метод проверяет, что следующее число простое
     */
    private void testNextNumber() {
        index++;
        if (values[index] == 1) {
            index++;
        }
        for (int i = 2; i < values[index]; i++) {
            if (values[index] % i == 0) {
                index++;
                i = 2;
            }
        }
    }

    /**
     * Метод проверяет, имеются ли в массиве простые числа
     * @return возвращает true если простые числа остались, false если нет
     */
    private boolean checkForSimplicity() {
        for (int value : values) {
            if (value % 2 != 0 || value == 2) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasNext() {
        return values.length > index + 1  && checkForSimplicity();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        testNextNumber();
        return values[index];
    }
}