package ru.job4j.list;

import net.jcip.annotations.ThreadSafe;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

@ThreadSafe
public class DynamicLinkedList<E> implements Iterable<E> {

    private int position = 0;
    private int modCount = 0;
    private int iteratorPosition;
    private Node<E> first;
    private Node<E> last;

    public synchronized void add(E value) {
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
        modCount++;
    }

    public Node<E> getFirst() {
        return first;
    }

    public synchronized E removeFirst() {
        E result = first.date;
        if (position == 1) {
            first = null;
            last = null;
        }
        if (position != 1) {
            first = first.next;
            first.previous = null;
        }
        position--;
        modCount++;
        return result;
    }

    public synchronized E removeLast() {
        E result = last.date;
        if (position == 1) {
            first = null;
            last = null;
        }
        if (position != 1) {
            last.previous.next = null;
            last = last.previous;
        }
        position--;
        modCount++;
        return result;
    }

    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    public static class Node<E> {
        public E date;
        public Node<E> next;
        Node<E> previous;

        public Node(E date) {
            this.date = date;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return position > iteratorPosition;
            }

            @Override
            public E next() {
                checkModificationException();
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                iteratorPosition++;
                return get(iteratorPosition - 1);
            }

            private void checkModificationException() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }
}