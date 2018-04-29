package ru.job4j;

public class Coffee {
    /**
     * Номиналы монет в автомате
     */
    private static final int[] NOTE = new int[] {1, 2, 5, 10};

    /**
     * Метод выдачи сдачи автомата
     * @param value купюра
     * @param price цена кофе
     * @return возвращает сдачу
     */
    int[] changes(int value, int price) {
        int remainder = value - price;
        int[] result = new int[15];

        for (int i = 0; remainder != 0; i++) {
            if (remainder >= 10) {
                remainder = remainder - NOTE[3];
                result[i] = NOTE[3];
                continue;
            }
            if (remainder >= 5) {
                remainder = remainder - NOTE[2];
                result[i] = NOTE[2];
                continue;
            }
            if (remainder >= 2) {
                remainder = remainder - NOTE[1];
                result[i] = NOTE[1];
                continue;
            }
            if (remainder < 2 && remainder != 0) {
                remainder = remainder - NOTE[0];
                result[i] = NOTE[0];
                continue;
            }
        }

        int j = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0) {
                result[j++] = result[i];
            }
        }
        int[] arrayWithoutNull = new int[j];
        System.arraycopy(result, 0, arrayWithoutNull, 0, j);

        return arrayWithoutNull;
    }
}