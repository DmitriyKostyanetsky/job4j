package productes;

public class Food extends Product{
    private String data;
    private int time;

    public Food(String name, int price, int barcode, String data, int time) {
        super(name, price, barcode);
        this.data = data;
        this.time = time;
    }

    @Override
    public void info() {
        super.info();
        System.out.print(" " + getData() + " " + getTime());
    }

    public String getData() {
        return data;
    }

    public int getTime() {
        return time;
    }
}