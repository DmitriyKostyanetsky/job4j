package ru.job4j.array;

import java.util.Arrays;

/**
 * @author Dmitriy Kostyanetsky (onlywarinfarfuture@gmail.com)
 * @version 1
 * @since 01.04.18
 */
public class ElementDelete {

    /**
     * Удалить элемент из массива.
     * @param array входящий массив.
     * @param input элемент который нужно удалить.
     * @return массив с удаленным элементом.
     */
    public int[] remove(int[] array, int input) {
        int index = 0;
        int result;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != input) {
                index++;
                continue;
            } else {
                array[i] = 0;
                result = array[array.length - 1];
                array[array.length - 1] = array[i];
                array[i] = result;
                index++;
                continue;
            }
        }
        return Arrays.copyOf(array, index - 1);
    }
}