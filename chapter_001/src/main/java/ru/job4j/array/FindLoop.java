package ru.job4j.array;

/**
 * @author Dmitriy Kostyanetsky (onlywarinfarfuture@gmail.com)
 * @version 1
 * @since 27.03.18
 */
public class FindLoop {

    /**
     * Поиск перебором.
     * @param data заданный массив.
     * @param el элемент, который нужнео найти.
     * @return найденный элемент.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}