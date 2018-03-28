package ru.job4j.array;

/**
 * @author Dmitriy Kostyanetsky (onlywarinfarfuture@gmail.com)
 * @version 1
 * @since 28.03.18
 */
public class BubbleSort {

    /**
     * Сортировка пузырьком.
     * @param array входящий массив.
     * @return Отсортированный массив.
     */
    public int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j >= 1; j--) {
                int swap = array[j];
                if (swap < array[j - 1]) {
                    array[j] = array[j - 1];
                    array[j - 1] = swap;
                }
            }
        }
    return array;
    }


}