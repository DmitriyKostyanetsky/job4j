package ru.job4j.array;

import java.util.Arrays;

/**
 * @author Dmitriy Kostyanetsky (onlywarinfarfuture@gmail.com)
 * @version 1
 * @since 02.04.18
 */
public class SortThree {

    /**
     * Сортировка пузырьком.
     * @param inputArray входящий массив.
     * @return отсортированный массив.
     */
    public int[] sortArray(int[] inputArray) {
        for (int i = 1; i < inputArray.length; i++) {
            for (int j = i; j >= 1; j--) {
                int swap = inputArray[j];
                if (swap < inputArray[j - 1]) {
                    inputArray[j] = inputArray[j - 1];
                    inputArray[j - 1] = swap;
                }
            }
        }
        return inputArray;
    }

    /**
     * Создание 3го массива, состоящего из 2ух других.
     * @param one первый массив.
     * @param second второй массив.
     * @return новый массив, состоящий из 2ух массивов.
     */
    public int[] newThirdArray(int[] one, int[] second) {
        int k = 0;
        int[] thirdArray = new int[one.length + second.length];
        for (int i = 0; i < one.length; i++) {
                thirdArray[i] = one[i];
        }
        for (int num = one.length; num < thirdArray.length; num++) {
            thirdArray[num] = second[k];
            k++;
        }
        return Arrays.copyOf(thirdArray, thirdArray.length);
    }
}