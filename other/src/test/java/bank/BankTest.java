package bank;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BankTest {

    private Bank bank;
    private List<Account> bankAccount;
    private List<String> bankDoc;
    private List<Account> orgAccount;
    private List<String> orgDoc;

    @Before
    public void setUp() {
        bankAccount = new ArrayList<Account>() {{
            add(new Account(40702, 810, "Perf"));
            add(new Account(30227, 840, "String"));
            add(new Account(40702, 978, "Damn"));
        }};
        bankDoc = new ArrayList<String>() {{
           add("Documents1");
           add("Documents2");
           add("Documents3");
        }};
        orgAccount = new ArrayList<Account>() {{
            add(new Account(30227, 810, "123"));
            add(new Account(30227, 840, "Regiz"));
            add(new Account(40702, 978, "UOL"));
        }};
        orgDoc = new ArrayList<String>() {{
            add("orgDocuments1");
            add("orgDocuments2");
            add("orgDocuments3");
        }};
    }

    @Test
    public void testBank() {
        bank = new Bank("Bank", "Addres", bankAccount, bankDoc);
        bank.addAccount("LOLO", 30227, 810);
    }
}