package ru.job4j.comparable;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {
    /**
     * Метод сортирует пользователей по возрасту
     * @param list пользователи
     * @return возвращает treeset пользователей по возрасту
     */
    public Set<User> sort(List<User> list) {
        int index = 0;
        TreeSet<User> result = new TreeSet<>(new User(list.get(index).getName(), list.get(index).getAge()));
        for (User value : list) {
            result.add(value);
        }
        return result;
    }
}