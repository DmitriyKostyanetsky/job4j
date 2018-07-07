package ru.job4j.task;

import org.junit.Test;
import ru.job4j.list.DynamicList;

public class StoreTest {

    private DynamicList<Store.User> previous;
    private DynamicList<Store.User> current;

    @Test
    public void checkInfo() {
        Store store = new Store();
        Store.User[] users = new Store.User[3];
        previous = new DynamicList<>(users);
        current = previous;
        previous.add(new Store.User(1, "Ivan"));
        previous.add(new Store.User(2, "Maxim"));
        previous.add(new Store.User(3, "Alexey"));
        current.remove(2);
        store.infoDiff(previous, current);
    }
}