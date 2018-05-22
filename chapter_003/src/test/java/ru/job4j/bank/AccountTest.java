package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTest {
    @Test
    public void whenTransferMoneyThenTrue() {
        Account account = new Account();
        User user = new User("Dmitriy", "52373363");
        User user1 = new User("Mike", "496738235");
        account.addUser(user);
        account.addUser(user1);
        account.addAccountToUser("52373363", new Account(2541, 3533));
        account.addAccountToUser("52373363", new Account(32563, 7462));
        account.addAccountToUser("496738235", new Account(10000, 8932));
        account.getUserAccounts("52373363");
        assertThat(account.transferMoney("52373363", "7462", "496738235", "8932", 5000), is(true));
    }

    @Test
    public void whenTransferMoneyThenFalse() {
        Account account = new Account();
        User user = new User("Dmitriy", "52373363");
        User user1 = new User("Mike", "496738235");
        account.addUser(user);
        account.addUser(user1);
        account.addAccountToUser("52373363", new Account(2541, 3533));
        account.addAccountToUser("52373363", new Account(32563, 7462));
        account.addAccountToUser("496738235", new Account(10000, 8932));
        account.getUserAccounts("52373363");
        assertThat(account.transferMoney("52373363", "3533", "496738235", "8932", 5000), is(false));
    }

    @Test
    public void whenSecondUserTransferMoneyThenTrue() {
        Account account = new Account();
        User user = new User("Dmitriy", "52373363");
        User user1 = new User("Mike", "496738235");
        account.addUser(user);
        account.addUser(user1);
        account.addAccountToUser("52373363", new Account(2541, 3533));
        account.addAccountToUser("52373363", new Account(32563, 7462));
        account.addAccountToUser("496738235", new Account(10000, 8932));
        account.getUserAccounts("52373363");
        assertThat(account.transferMoney("496738235", "8932", "52373363", "3533", 5000), is(true));
    }

    @Test
    public void whenSecondUserTransferMoneyThenFalse() {
        Account account = new Account();
        User user = new User("Dmitriy", "52373363");
        User user1 = new User("Mike", "496738235");
        account.addUser(user);
        account.addUser(user1);
        account.addAccountToUser("52373363", new Account(2541, 3533));
        account.addAccountToUser("52373363", new Account(32563, 7462));
        account.addAccountToUser("496738235", new Account(3999, 8932));
        account.getUserAccounts("52373363");
        assertThat(account.transferMoney("496738235", "8932", "52373363", "3533", 5000), is(false));
    }

    @Test
    public void whenAmountLessZeroThenFalse() {
        Account account = new Account();
        User user = new User("Dmitriy", "52373363");
        User user1 = new User("Mike", "496738235");
        account.addUser(user);
        account.addUser(user1);
        account.addAccountToUser("52373363", new Account(2541, 3533));
        account.addAccountToUser("496738235", new Account(3999, 8932));
        account.getUserAccounts("52373363");
        assertThat(account.transferMoney("496738235", "8932", "52373363", "3533", -1000), is(false));
    }

    @Test
    public void whenRequisitesZeroThenFalse() {
        Account account = new Account();
        User user = new User("Dmitriy", "52373363");
        User user1 = new User("Mike", "496738235");
        account.addUser(user);
        account.addUser(user1);
        account.addAccountToUser("52373363", new Account(2541, 3533));
        account.addAccountToUser("496738235", new Account(3999, 8932));
        account.getUserAccounts("52373363");
        assertThat(account.transferMoney("", "8932", "52373363", "0", 5000), is(false));
    }
}