package ru.job4j.loop;

/**
 *@author Dmitriy Kostyanetsky (onlywarinfarfuture@gmail.com)
 *@version 1
 *@since 26.03.18
 */

public class Factorial {

    /**
     * Рассчет факториала
     * @param n положительное целое число
     * @return Фактоиал
     */
    public int calc(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
           factorial *= i;
        }
        return factorial;
    }
}