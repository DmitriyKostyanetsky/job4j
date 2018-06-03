package ru.job4j.list;

public class SimpleArrayList<E> {

    private int size;
    private Node<E> first;

    public void add(E date) {
        Node<E> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    public E delete(int index) {
        Node<E> result;
        if (index >= size || index < 0) {
            return null;
        }
        if (index == 0) {
            this.first = this.first.next;
            result = this.first;
            size--;
            return result.date;
        }
        Node<E> current = this.first;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        result = current;
        size--;
        return result.date;
    }

    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    public int getSize() {
        return this.size;
    }

    private static class Node<E> {
        E date;
        Node<E> next;

        Node(E date) {
            this.date = date;
        }
    }
}