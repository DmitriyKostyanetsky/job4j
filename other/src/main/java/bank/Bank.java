package bank;

import java.util.List;

public class Bank extends Information {

    private List<Account> bankAccount;
    private List<String> bankDoc;

    public Bank(String name, String address, List<Account> account, List<String> documents) {
        super(name, address, account, documents);
        this.bankAccount = account;
        this.bankDoc = documents;
    }

    public void addAccount (String organization, int type, int currency) {
        bankAccount.add(new Account(type, currency, organization));
        bankDoc.add(organization + " docOrg");
    }
}