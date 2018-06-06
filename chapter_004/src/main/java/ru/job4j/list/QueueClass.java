package ru.job4j.list;

public class QueueClass<T> {
    DynamicLinkedList<T> list = new DynamicLinkedList<>();

    public QueueClass(DynamicLinkedList<T> list) {
        this.list = list;
    }

    public T poll() {
        return list.removeLast();
    }

    public void push(T value) {
        list.add(value);
    }
}