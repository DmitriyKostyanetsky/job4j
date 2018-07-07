package ru.job4j.task;

import ru.job4j.list.DynamicList;

public class Store {

    public void infoDiff(DynamicList<User> previous, DynamicList<User> current) {
        System.out.println("Previous: Add: " + previous.getAddCount() + " Change: " + previous.getChangeCount() + " Remove: " + previous.getRemCount());
        System.out.println("Current: Add: " + current.getAddCount() + " Change: " + current.getChangeCount() + " Remove: " + current.getRemCount());
    }

    static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}