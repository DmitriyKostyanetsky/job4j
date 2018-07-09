package ru.job4j.task;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StoreTest {

    private List<Store.User> current;

    @Before
    public void setUp() {
        current = new ArrayList<>();
        current.add(new Store.User(1, "Ivan"));
        current.add(new Store.User(2, "Maxim"));
        current.add(new Store.User(3, "Alexey"));
    }

    @Test
    public void checkInfo() {
        List<Store.User> next = new ArrayList<>();
        next.addAll(current);
        Store store = new Store();
        next.remove(2);
        next.add(new Store.User(3, "Jim"));
        next.add(new Store.User(4, "Martin"));
        store.diff(current, next);
    }
}