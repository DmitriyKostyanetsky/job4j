package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicLinkedList<E> implements Iterable<E> {

    private int position = 0;
    private int modCount = 0;
    private int expectedModCount = modCount;
    private Node<E> first;
    private Node<E> last;

    public void add(E value) {
        Node<E> newLink = new Node<>(value);
        Node<E> temp = first;
        first = newLink;
        first.next = temp;
        if (position == 0) {
            last = first;
        }
        if (position != 0) {
            temp.previous = first;
        }
        position++;
        expectedModCount++;
    }

    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    private static class Node<E> {
        E date;
        Node<E> next;
        Node<E> previous;

        Node(E date) {
            this.date = date;
        }
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
                return modCount - 1 < position;
            }

            @Override
            public E next() {
                checkModificationException();
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(modCount++);
            }
        };
    }
}