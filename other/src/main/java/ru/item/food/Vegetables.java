package ru.item.food;

import ru.item.Food;

public class Vegetables extends Food {

    private String type;

    public Vegetables(String name, int price, int barcode, String data, int time, String type) {
        super(name, price, barcode, data, time);
        this.type = type;
    }

    @Override
    public void info() {
        super.info();
        System.out.println(" " + getType());
    }

    public String getType() {
        return type;
    }
}