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
        int index = 0;
        for (User value : list) {
            result.put(value.getId(), list.get(index));
            System.out.println(String.format("%s : %s", value.getId(), value.getName() + " " + value.getCity()));
            index++;
        }
        return  result;
    }
}
