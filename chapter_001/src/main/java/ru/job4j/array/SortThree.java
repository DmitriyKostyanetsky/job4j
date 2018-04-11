package ru.job4j.array;

import java.util.Arrays;

/**
 * @author Dmitriy Kostyanetsky (onlywarinfarfuture@gmail.com)
 * @version 2
 * @since 11.04.18
 */
public class SortThree {

    /**
     * Создание 3го массива, состоящего из 2ух других.
     * @param one первый массив.
     * @param second второй массив.
     * @return новый массив, состоящий из 2ух массивов.
     */
    public int[] newThirdArray(int[] one, int[] second) {
        int oneIndex = 0;
        int secondIndex = 0;
        int[] thirdArray = new int[one.length + second.length];
        for (int i = 0; i < thirdArray.length; i++) {
            while (oneIndex < one.length && secondIndex < second.length) {
                if (one[oneIndex] < second[secondIndex]) {
                    thirdArray[i] = one[oneIndex];
                    oneIndex++;
                    break;
                } else {
                    thirdArray[i] = second[secondIndex];
                    secondIndex++;
                    break;
                }
            }
        }
        if (oneIndex < one.length) {
            System.arraycopy(one, oneIndex, thirdArray, oneIndex + secondIndex, one.length - oneIndex);
        } else {
            System.arraycopy(second, secondIndex, thirdArray, oneIndex + secondIndex, second.length - secondIndex);
        }

        return thirdArray;
    }
}