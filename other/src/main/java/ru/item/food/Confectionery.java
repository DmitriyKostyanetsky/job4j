package ru.item.food;

import ru.item.Food;

public class Confectionery extends Food {
    private double calories;

    public Confectionery(String name, int price, int barcode, String data, int time, double calories) {
        super(name, price, barcode, data, time);
        this.calories = calories;
    }

    @Override
    public void info() {
        super.info();
        System.out.println(" " + getCalories());
    }

    public double getCalories() {
        return calories;
    }
}