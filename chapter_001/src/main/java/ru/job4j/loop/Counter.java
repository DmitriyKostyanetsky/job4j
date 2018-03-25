package ru.job4j.loop;

/**
 *@author Dmitriy Kostyanetsky (onlywarinfarfuture@gmail.com)
 *@version 1
 *@since 25.03.18
 */
public class Counter {

    /**
     * Подсчет четных чисел в диапозоне.
     * @param start начало диапозона.
     * @param finish конец диапозона.
     * @return Сумма четных чисел в диапозоне от 0 до 10.
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (start = 0; start <= finish; start++) {
            if (start % 2 == 0) {
                sum += start;
            }
        }
        return sum;
    }
}