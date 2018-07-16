package ru.item;

public class Chancery extends Product {
    private String manufacturer;

    public Chancery(String name, int price, int barcode, String manufacturer) {
        super(name, price, barcode);
        this.manufacturer = manufacturer;
    }

    @Override
    public void info() {
        super.info();
        System.out.printf(" " + getManufacturer());
    }

    public String getManufacturer() {
        return manufacturer;
    }
}