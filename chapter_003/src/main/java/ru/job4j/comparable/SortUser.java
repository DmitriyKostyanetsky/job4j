package ru.job4j.comparable;

import java.util.*;

public class SortUser {
    /**
     * Метод сортирует пользователей по возрасту
     * @param list пользователи
     * @return возвращает treeset пользователей по возрасту
     */
    public Set<User> sort(List<User> list) {
        Set<User> result = new TreeSet<>(list);
        return result;
    }

    public List<User> sortNameLength(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                Integer length1 = o1.getName().length();
                Integer length2 = o2.getName().length();
                return length1.compareTo(length2);
            }
        });
        return new ArrayList<>(list);
    }

    public List<User> sortByAllFields(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int res = o1.getName().compareTo(o2.getName());
                if (res == 0) {
                    res = o1.getAge() - o2.getAge();
                }
                return res;
            }
        });
        return new ArrayList<>(list);
    }
}