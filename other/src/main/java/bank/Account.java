package bank;

public class Account {
    private int type;
    private int currency;
    private String number;
    private String organization;

    public Account(int type, int currency, String organization) {
        this.type = type;
        this.currency = currency;
        this.organization = organization;
        setNumber(number);
        this.number = getNumber();
    }

    public void setNumber(String number) {
        number = String.valueOf(type) + String.valueOf(currency) + String.valueOf(Math.random());
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}