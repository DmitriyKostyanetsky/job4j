package ru.job4j;

import java.util.ArrayList;

public class Coffee {
    /**
     * Номиналы монет в автомате
     */
    private static final int[] NOTE = new int[]{10, 5, 2, 1};

    /**
     * Метод выдачи сдачи автомата
     * @param value купюра
     * @param price цена кофе
     * @return возвращает сдачу
     */
    public ArrayList<Integer> changes(int value, int price) {
        int remainder = value - price;
        ArrayList<Integer> result = new ArrayList<>();
        for (int coin : NOTE) {
            while (remainder - coin >= 0) {
                result.add(coin);
                remainder = remainder - coin;
            }
        }
        return result;
    }
}