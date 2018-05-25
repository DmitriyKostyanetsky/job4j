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

    private void testNextNumber() {
        index++;
        while (index < values.length && values[index] % 2 == 1) {
            index++;
        }
    }

    @Override
    public boolean hasNext() {
        return values.length > index;
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