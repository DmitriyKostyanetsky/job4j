package bank;

import java.util.List;

public class Organization extends Information {

    public Organization(String name, String address, List<Account> account, List<String> documents) {
        super(name, address, account, documents);
    }
}