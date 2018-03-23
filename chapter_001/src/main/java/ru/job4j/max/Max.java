package ru.job4j.max;

/**
 *@author Dmitriy Kostyanetsky (onlywarinfarfuture@gmail.com)
 *@version 1
 *@since 23.03.18
 */
public class Max {

    /**
     * Максимум из двух чисел
     * @param first, second Два числа
     * @return max Максимум из двух чисел
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
}