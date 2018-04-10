package ru.job4j.array;

/**
 * @author Dmitriy Kostyanetsky (onlywarinfarfuture@gmail.com)
 * @version 2
 * @since 11.04.18
 */
public class ArrayCharUp {

    /**
     * Проверка, что одно слово находится в другом слове.
     * @param origin Входящее слово.
     * @param sub префикс.
     * @return если в слове есть префикс.
     */
    public boolean contains(String origin, String sub) {
        boolean result = true;
        int current = 0;
        char[] valueOrigin = origin.toCharArray();
        char[] valueSub = sub.toCharArray();
        char[] prefixInOrigin = new char[valueSub.length];
        for (int i = 0; i < valueOrigin.length; i++) {
            if (valueOrigin[i] == valueSub[current]) {
                for (int j = 0; j < prefixInOrigin.length; j++) {
                    prefixInOrigin[j] = valueOrigin[i];
                    i++;
                }
            }
        }
        for (int k = 0; k < prefixInOrigin.length; k++) {
            if (prefixInOrigin[k] == valueSub[k]) {
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }
}