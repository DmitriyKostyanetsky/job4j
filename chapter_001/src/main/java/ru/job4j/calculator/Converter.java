package ru.job4j.calculator;

/**
 * Конвертер валюты.
 */
public class Converter {

    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    private static final int EURO = 70;
    private static final int DOLLAR = 60;
    public int rubleToEuro(int value) {
       return value / EURO;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллоры.
     */
    public int rubleToDollar(int value) {
        return value / DOLLAR;
    }
}