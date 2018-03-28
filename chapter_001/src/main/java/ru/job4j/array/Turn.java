package ru.job4j.array;

/**
 * @author Dmitriy Kostyanetsky (onlywarinfarfuture@gmail.com)
 * @version 1
 * @since 28.03.18
 */
public class Turn {

    /**
     * Перевернуть массив.
     * @param array входящий массив.
     * @return перевернутый массив.
     */
    public int[] turn(int[] array) {
        for (int index = 0; index < array.length / 2; index++) {
            int result = array[index];
            array[index] = array[array.length - index - 1];
            array[array.length - index - 1] = result;
        }
        return array;
    }
}