package ru.job4j.set;

import ru.job4j.list.DynamicList;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {

    private E[] container;
    private DynamicList<E> dynamicList;

    public SimpleSet(E[] container) {
        dynamicList = new DynamicList<>(this.container = container);
    }

    public void add(E e) {
        for (int i = 0; i < container.length; i++) {
            if (container[i] == null) {
                dynamicList.add(e);
                break;
            }
            if (container[i].equals(e)) {
                container[i] = e;
                break;
            }
        }
    }

    @Override
    public Iterator<E> iterator() {
        return dynamicList.iterator();
    }
}