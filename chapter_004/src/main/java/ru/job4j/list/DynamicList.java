package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicList<E> implements Iterable<E> {

    private E[] container;
    private int position = 0;
    private int modCount = 0;
    private int expectedModCount = modCount;

    public DynamicList(E[] container) {
        this.container = container;
    }

    private void increaseArray() {
        container = Arrays.copyOf(container, container.length + 1);
    }

    public void add(E value) {
        checkModificationException();
        if (position == container.length) {
            increaseArray();
            modCount++;
        }
        if (iterator().hasNext()) {
            container[position++] = value;
        }
        expectedModCount++;
    }

    public E get(int index) {
        return container[index];
    }

    private void checkModificationException() {
        if (modCount != expectedModCount)
            throw new ConcurrentModificationException();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                checkModificationException();
                return container.length > position;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[position++];
            }
        };
    }
}