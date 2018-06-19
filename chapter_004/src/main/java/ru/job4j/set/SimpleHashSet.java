package ru.job4j.set;

import java.util.Arrays;

public class SimpleHashSet<E> {

    private E[] container;
    private int position = 0;
    private E value;

    public SimpleHashSet(E[] container) {
        this.container = container;
    }

    private void checkArray() {
        if (position == container.length) {
            container = Arrays.copyOf(container, container.length + 10);
        }
    }

    private boolean checkEquals(E e) {
        for (int i = 0; i < container.length; i++) {
            if (container[i] != null && container[i].equals(e)) {
                container[i] = e;
                return false;
            }
        }
        return true;
    }

    boolean add(E e) {
        value = e;
        int hashSum = Math.abs(hashCode() % container.length);
        checkArray();
        if (checkEquals(e)) {
            container[hashSum] = e;
            position++;
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + value.hashCode();
        return result;
    }

    boolean contains(E e) {
        value = e;
        int hashSum = Math.abs(hashCode() % container.length);
        return container[hashSum] == e;
    }

    boolean remove(E e) {
        value = e;
        int hashSum = Math.abs(hashCode() % container.length);
        if (container[hashSum] == e) {
            container[hashSum] = null;
            return true;
        }
        return false;
    }
}