package ru.job4j.array;

import java.util.Arrays;

/**
 * @author Dmitriy Kostyanetsky (onlywarinfarfuture@gmail.com)
 * @version 1
 * @since 28.03.18
 */
public class ArrayDuplicate {

    /**
     * Удаление дубликатов в массиве.
     * @param array входящий массив.
     * @return массив без дубликатов.
     */
     public String[] remove(String[] array) {
         int numOfDuplicate = array.length;
         for (int i = 0; i < numOfDuplicate; i++) {
             for (int j = i + 1; j < numOfDuplicate; j++) {
                 if (array[i].equals(array[j])) {
                     array[j] = array[numOfDuplicate - 1];
                     numOfDuplicate--;
                     j--;
                 }
             }
         }
         return Arrays.copyOf(array, numOfDuplicate);
     }
}