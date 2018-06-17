package ru.job4j.set;

import ru.job4j.list.DynamicList;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {

    private DynamicList<E> dynamicList;

    public SimpleSet(E[] container) {
        dynamicList = new DynamicList<>(container);
    }

    public void add(E e) {
        for (int i = 0; i < dynamicList.getContainer().length; i++) {
            if (dynamicList.getContainer()[i] == null) {
                dynamicList.add(e);
                break;
            }
            if (dynamicList.getContainer()[i].equals(e)) {
                dynamicList.getContainer()[i] = e;
                break;
            }
        }
    }

    @Override
    public Iterator<E> iterator() {
        return dynamicList.iterator();
    }
}