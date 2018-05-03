package ru.job4j.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertMatrix2List {

    /**
     * Метод преобразует двумерный массив в лист
     * @param array двумерный массив
     * @return возвращает коллекцию чисел
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();

        for (int[] value : array) {
            for (int val : value) {
                Integer.valueOf(val);
                list.addAll(Arrays.asList(val));
            }
        }

        return list;
    }
}
