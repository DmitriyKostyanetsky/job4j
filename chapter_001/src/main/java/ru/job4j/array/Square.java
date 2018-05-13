package ru.job4j.array;

/**
 *@author Dmitriy Kostyanetsky (onlywarinfarfuture@gmail.com)
 *@version 1
 *@since 27.03.18
 */
public class Square {

    /**
     * Заполнение массива степенями чисел.
     * @param bound количество чисел.
     * @return Заполненный массив.
     */
    public int[] calculate(int bound) {
        int[] result = new int[bound];
        for (int i = 0; i < bound; i++) {
            result[i] = (int) Math.pow(i + 1, 2);
        }
        return result;
    }
}