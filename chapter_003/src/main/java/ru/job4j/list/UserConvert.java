package ru.job4j.list;

import java.util.HashMap;
import java.util.List;

/**
 * Программа преобразования List в Map.
 */
public class UserConvert {

    /**
     * Метод принимает список пользователей и конвертирует в Map
     * @param list список пользователей
     * @return возвращает список пользователей с ключом Integer id
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for (User value : list) {
            result.put(value.getId(), value);
        }
        return  result;
    }
}