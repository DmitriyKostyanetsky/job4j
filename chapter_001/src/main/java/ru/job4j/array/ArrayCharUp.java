package ru.job4j.array;

/**
 * @author Dmitriy Kostyanetsky (onlywarinfarfuture@gmail.com)
 * @version 1
 * @since 31.03.18
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
        char[] valueOrigin = origin.toCharArray();
        char[] valueSub = sub.toCharArray();
        for (int i = 0; i < valueOrigin.length; i++) {
            if (valueOrigin[i] == valueSub[0]) {
                for (char name : valueSub) {
                    if (valueOrigin[i] == name) {
                        i++;
                    } else {
                        result = false;
                        break;
                    }
                }
            }
        }
        return result;
    }
}