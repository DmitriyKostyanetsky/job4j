package productes;

public class Product {
    private String name;
    private int price;
    private int barcode;

    public Product(String name, int price, int barcode) {
        this.name = name;
        this.price = price;
        setBarcode(barcode);
        this.barcode = getBarcode();
    }

    public void setBarcode(int barcode) {
        barcode = (int) (Math.random() * 1234567891);
        this.barcode = barcode;
    }

    public void info() {
        System.out.print(getName() + " " + getPrice() + " " + getBarcode());
    }

    public int getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}