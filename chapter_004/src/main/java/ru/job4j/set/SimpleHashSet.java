package ru.job4j.set;

import java.util.Arrays;

public class SimpleHashSet<E> {

    private E[] container;
    private int position = 0;

    public SimpleHashSet(E[] container) {
        this.container = container;
    }

    private void checkArray() {
        if (position == container.length) {
            container = Arrays.copyOf(container, container.length + 10);
            for (int i = 0; i < container.length; i++) {
                if (container[i] != null) {
                    int newIndex = Math.abs(container[i].hashCode() % container.length);
                    if (container[newIndex] == null) {
                        container[newIndex] = container[i];
                        container[i] = null;
                        continue;
                    }
                    if (container[newIndex] != null) {
                        E temp = container[newIndex];
                        container[newIndex] = container[i];
                        container[i] = temp;
                    }
                }
            }
        }
    }

    private boolean hasDuplicate(E e) {
        int hashSum = Math.abs(e.hashCode() % container.length);
        return container[hashSum] == null;
    }

    boolean add(E e) {
        checkArray();
        int hashSum = Math.abs(e.hashCode() % container.length);
        if (hasDuplicate(e)) {
            container[hashSum] = e;
            position++;
            return true;
        }
        return false;
    }

    boolean contains(E e) {
        int hashSum = Math.abs(e.hashCode() % container.length);
        return container[hashSum].equals(e);
    }

    boolean remove(E e) {
        int hashSum = Math.abs(e.hashCode() % container.length);
        if (container[hashSum].equals(e)) {
            container[hashSum] = null;
            return true;
        }
        return false;
    }
}