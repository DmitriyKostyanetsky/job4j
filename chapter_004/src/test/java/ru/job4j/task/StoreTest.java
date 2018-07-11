package ru.job4j.task;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StoreTest {

    private List<Store.User> current;
    private List<Store.User> next;

    @Before
    public void setUp() {
        current = new ArrayList<>();
        next = new ArrayList<>();
        current.add(new Store.User(1, "Ivan"));
        current.add(new Store.User(2, "Maxim"));
        current.add(new Store.User(3, "Alexey"));
        next.add(new Store.User(2, "Maxim"));
        next.add(new Store.User(3, "Andrey"));
        next.add(new Store.User(4, "Stanislav"));
    }

    @Test
    public void checkInfo() {
        Store store = new Store();
        store.diff(current, next);
    }
}