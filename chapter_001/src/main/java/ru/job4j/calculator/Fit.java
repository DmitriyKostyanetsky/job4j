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
    public double manWeight(double height) {
        final int growthMan = 100;
        final double multiplier = 1.15;
        return (height - growthMan) * multiplier;
    }

    /**
     * Идеальный вес для женщины.
     * @param height Рост.
     * @return идеальный вес.
     */
    public double womanWeight(double height) {
        final int growthWoman = 110;
        final double multiplier = 1.15;
        return (height - growthWoman) * multiplier;
    }
}