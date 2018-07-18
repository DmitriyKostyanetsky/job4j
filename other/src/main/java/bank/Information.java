package bank;

import java.util.List;

public abstract class Information {
    private String name;
    private String address;
    private List<Account> account;
    private List<String> documents;

    public Information(String name, String address, List<Account> account, List<String> documents) {
        this.name = name;
        this.address = address;
        this.account = account;
        this.documents = documents;
    }
}