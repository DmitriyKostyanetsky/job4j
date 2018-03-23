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
    public int rubleToEuro(int value) {
        final int Euro = 70;
       return value / Euro;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллоры.
     */
    public int rubleToDollar(int value) {
        final int Dollar = 60;
        return value / Dollar;
    }
}