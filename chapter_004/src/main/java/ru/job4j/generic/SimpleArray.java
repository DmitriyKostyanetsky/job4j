package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {

    private T[] array;

    public SimpleArray(T[] array) {
        this.array = array;
    }

    public void add(T model) {
        for (int i = array.length; i == array.length; i++) {
            array[i - 1] = model;
        }
    }

    public void set(int index, T model) {
        array[index] = model;
    }

    public void delete(int index) {
        for (int i = index; i < array.length; i++) {
            if (i == array.length - 1) {
                array[array.length - 1] = null;
                break;
            }
            array[i] = array[i + 1];
        }
    }

    public T get(int index) {
        return array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleArrayIterator(array);
    }

    private class SimpleArrayIterator implements Iterator<T> {

        private T[] values;
        private int index = 0;

        private SimpleArrayIterator(T[] values) {
            this.values = values;
        }

        @Override
        public boolean hasNext() {
            return values.length > index;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return values[index++];
        }
    }
}