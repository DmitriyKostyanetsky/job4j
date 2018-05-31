package ru.job4j.generic;

public class UserStore extends AbstractStore<User> {

    public UserStore(User[] array, SimpleArray<User> models) {
        super(array, models);
    }
}