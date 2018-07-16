package productes.chancery;

import productes.Chancery;

public class Notebook extends Chancery {
    private String type;
    private int quantity;

    public Notebook(String name, int price, int barcode, String manufacturer,final String type, int quantity) {
        super(name, price, barcode, manufacturer);
        this.type = type;
        this.quantity = quantity;
    }

    @Override
    public void info() {
        super.info();
        System.out.println(" " + getType() + " " + getQuantity());
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }
}