package ru.item.chancery;

import ru.item.Chancery;

public class Pencil extends Chancery {
    private String color;
    private int thickness;

    public Pencil(String name, int price, int barcode, String manufacturer, String color, int thickness) {
        super(name, price, barcode, manufacturer);
        this.color = color;
        this.thickness = thickness;
    }

    @Override
    public void info() {
        super.info();
        System.out.println(" " + getColor() + " " + getThickness());
    }

    public String getColor() {
        return color;
    }

    public int getThickness() {
        return thickness;
    }
}