package ru.job4j.comparable;

import java.util.Comparator;

public class User implements Comparable<User> {
    private String name;
    private int age;

    User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String getName() {
        return name;
    }

    private int getAge() {
        return age;
    }

    @Override
    public int compareTo(User o) {
        return Comparators.NAME.compare(this, o);
    }

    static class Comparators {
        static Comparator<User> AGE = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge() - o2.getAge();
            }
        };

        static Comparator<User> LENGTH = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                Integer length1 = o1.getName().length();
                Integer length2 = o2.getName().length();
                return length1.compareTo(length2);
            }
        };

        static Comparator<User> NAME = new Comparator<User>() {
            @Override
            public int compare(User one, User two) {
                return one.name.compareTo(two.name);
            }
        };

        static Comparator<User> NAMEAGE = new Comparator<User>() {
            @Override
            public int compare(User one, User two) {
                int res = one.name.compareTo(two.name);
                if (res == 0) {
                    res = one.getAge() - two.getAge();
                }
                return res;
            }
        };
    }
}