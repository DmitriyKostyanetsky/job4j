package ru.job4j.comparable;

import java.util.Comparator;

public class User implements Comparator<User> {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compare(User o1, User o2) {
        int result = 0;
        if (o1.getAge() > o2.getAge()) {
            result = 1;
        }
        if (o1.getAge() < o2.getAge()) {
            result = -1;
        }
        return result;
    }
}