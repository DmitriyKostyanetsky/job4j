package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertList2Array {

    /**
     * Метод разбивает лист на кол-во строк двумерного массива
     * @param list список чисел
     * @param rows кол-во чисел в строке
     * @return возвращает двумерный массив
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil((double) list.size() / rows);
        int[][] array = new int[rows][cells];
        int row = 0;
        int cell = 0;
        for (Integer value : list) {
            array[row][cell++] = value;
            if (cell >= cells) {
                row++;
                cell = 0;
            }
        }
        return array;
    }

    /**
     * Метод проходится по всем массивам в списке List
     * Добавляет их в один общий лист Integer
     * @param list исходный list
     * @return возвращет общий list
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] value : list) {
            for (int val : value) {
                result.add(val);
            }
        }
        return result;
    }
}