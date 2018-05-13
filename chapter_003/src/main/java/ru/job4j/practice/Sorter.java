package ru.job4j.practice;
/**Пробелы*/


import ru.job4j.comparable.User;

import java.util.*;

public class Sorter {

    /**Пустой конструктор*/
    public Sorter(){

    }

    Set<User> sort (List<User> list) {
        /**return new TreeSet<>(list);*/
        TreeSet<User> sortedList = new TreeSet<>();
        sortedList.addAll(list);
        return sortedList;
    }

    List<User> sortnamelength (List<User> list) {
        Comparator<User> compar = new Comparator<User>() {
            @Override
            public int compare (User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }
        };
        list.sort(compar);
        return list;
    }

    List<User> sortboth (List<User> list) {
        Comparator<User> compar1 = new Comparator<User>() {
            /**Можно написать один общий метод compare
            int res = o1.getName().compareTo(o2.getName());
                if (res == 0) {
                res = o1.getAge() - o2.getAge();
            }
                return res;
             */
            @Override
            public int compare (User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Comparator<User> compar2 = new Comparator<User>() {
            @Override
            public int compare (User o1, User o2) {
                return o1.getAge() - o2.getAge();
            }
        };
        list.sort(compar1.thenComparing(compar2));
        return list;
    }
}