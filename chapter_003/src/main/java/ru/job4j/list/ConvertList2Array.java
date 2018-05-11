package ru.job4j.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ConvertList2Array {

    /**
     * Метод разбивает лист на кол-во строк двумерного массива
     * @param list список чисел
     * @param rows кол-во чисел в строке
     * @return возвращает двумерный массив
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (list.size() / rows) + 1;
        Iterator<Integer> iterator = list.iterator();
        int[][] array = new int[cells][rows];
        for (int i = 0; i < cells; i++) {
            for (int j = 0; j < rows; j++) {
                if (iterator.hasNext()) {
                    array[i][j] = iterator.next().intValue();
                }
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
        for (int[] value : list){
            for (int val : value) {
                result.add(val);
            }
        }
        return result;
    }
}