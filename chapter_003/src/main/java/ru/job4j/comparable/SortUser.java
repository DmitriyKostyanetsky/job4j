package ru.job4j.comparable;

import java.util.ArrayList;
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
        TreeSet<User> result = new TreeSet<>(User.Comparators.AGE);
        result.addAll(list);
        return result;
    }

    public List<User> sortNameLength(List<User> list){
        list.sort(User.Comparators.LENGTH);
        ArrayList<User> result = new ArrayList<>();
        result.addAll(list);
        return result;
    }

    public List<User> sortByAllFields(List<User> list) {
        list.sort(User.Comparators.NAMEAGE);
        ArrayList<User> result = new ArrayList<>();
        result.addAll(list);
        return result;
    }
}