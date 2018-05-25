package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorForArray<T> implements Iterator<Integer> {

    private final int[][] values;
    private int i = 0;
    private int j = 0;

    public IteratorForArray(int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return values.length > i && values[i].length > j;
    }

    @Override
    public Integer next() {
        Integer result = 0;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        result = values[i][j];
        j++;
        if (values[i].length == j) {
            j = 0;
            i++;
        }
        return result;
    }
}