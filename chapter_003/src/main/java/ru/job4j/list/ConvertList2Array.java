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
        ArrayList<Integer> arrayList = new ArrayList<>(list);
        int remainder = rows - (list.size() % rows);
        int cells = (list.size() / rows) + 1;

        if (remainder != 0) {
            while (remainder != 0) {
                arrayList.add(arrayList.size(), 0);
                remainder--;
            }
        }

        int[] result = new int[arrayList.size()];
        Iterator<Integer> iterator = arrayList.iterator();
        for (int i = 0; i < result.length; i++) {
            result[i] = iterator.next().intValue();
        }

        int index = 0;
        int[][] array = new int[cells][rows];
        for (int i = 0; i < cells; i++) {
            for (int j = 0; j < rows; j++) {
                array[i][j] = result[index];
                index++;
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
                Integer.valueOf(val);
                result.addAll(Arrays.asList(val));
            }
        }
        return result;
    }
}
