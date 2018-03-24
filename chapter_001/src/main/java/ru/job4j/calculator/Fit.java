package ru.job4j.calculator;

/**
 * Программа расчета идеального веса.
 */
public class Fit {

    /**
     * Идеальный вес для мужчины.
     * @param height Рост.
     * @return идеальный вес.
     */

    private static final int GROWTHMAN = 100;
    private static final int GROWTHWOMAN = 110;
    private static final double MULTIPLIER = 1.15;

    public double manWeight(double height) {
        return (height - GROWTHMAN) * MULTIPLIER;
    }

    /**
     * Идеальный вес для женщины.
     * @param height Рост.
     * @return идеальный вес.
     */
    public double womanWeight(double height) {
        return (height - GROWTHWOMAN) * MULTIPLIER;
    }
}