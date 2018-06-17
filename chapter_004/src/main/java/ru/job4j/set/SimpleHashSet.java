package ru.job4j.set;

import java.util.Arrays;

public class SimpleHashSet<E> {

    private E[] values;
    private int position = 0;
    private Integer[] key;

    public SimpleHashSet(E[] values) {
        this.values = values;
        key = new Integer[values.length];
    }

    private void checkArray() {
        if (position == values.length) {
            values = Arrays.copyOf(values, values.length + 1);
        }
        if (position == key.length) {
            key = Arrays.copyOf(key, key.length + 1);
        }
    }

    boolean add(E e) {
        for (int i = 0; i < values.length; i++) {
            checkArray();
            if (values[i] != null && values[i].equals(e)) {
                values[i] = e;
                return false;
            }
            if (values[i] == null) {
                key[i] = e.hashCode() * 12;
                values[position++] = e;
                break;
            }
        }
        return true;
    }

    boolean contains(E e) {
        for (E value : values) {
            if (value.equals(e)) {
                return true;
            }
        }
        return false;
    }

    boolean remove(E e) {
        for (int i = 0; i < values.length; i++) {
            if (values[i].equals(e)) {
                values[i] = null;
                return true;
            }
        }
        return false;
    }
}