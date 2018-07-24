package ru.job4j.list;

import net.jcip.annotations.ThreadSafe;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

@ThreadSafe
public class DynamicList<E> implements Iterable<E> {

    private E[] container;
    private int position = 0;
    private int modCount = 0;
    private int iteratorPosition;

    public DynamicList(E[] container) {
        this.container = container;
    }

    private void increaseArray() {
        container = Arrays.copyOf(container, container.length + 1);
    }

    public synchronized void add(E value) {
        if (position == container.length) {
            increaseArray();
        }
        container[position++] = value;
        modCount++;
    }

    public synchronized boolean remove(int index) {
        boolean result = false;
        if (container[index] != null) {
            container[index] = null;
            return true;
        }
        return false;
    }

    public E get(int index) {
        return container[index];
    }

    public E[] getContainer() {
        return container;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return container.length > iteratorPosition;
            }

            @Override
            public E next() {
                checkModificationException();
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[iteratorPosition++];
            }

            private void checkModificationException() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }
}