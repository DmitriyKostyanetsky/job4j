package ru.job4j.set;

import ru.job4j.list.DynamicLinkedList;

import java.util.Iterator;

public class SimpleSetNode<E> implements Iterable<E> {

    private DynamicLinkedList<E> list = new DynamicLinkedList<>();

    private boolean checkEquals(E e) {
        DynamicLinkedList.Node<E> temp = list.getFirst();
        while (temp != null) {
            if (temp.date.equals(e)) {
                return false;
            }
            temp = temp.next;
        }
        return true;
    }

    public void add(E e) {
        if (checkEquals(e)) {
            list.add(e);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
}