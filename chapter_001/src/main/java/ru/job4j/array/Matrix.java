package ru.job4j.array;

/**
 * @author Dmitriy Kostyanetsky (onlywarinfarfuture@gmail.com)
 * @version 1
 * @since 28.03.18
 */
public class Matrix {

    /**
     * Таблица умножения.
     * @param size размер таблицы.
     * @return построенная таблица.
     */
    public int[][] multiple(int size) {
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = (i + 1) * (j + 1);
            }
        }
        return result;
    }
}