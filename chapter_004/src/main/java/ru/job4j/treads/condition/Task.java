package ru.job4j.treads.condition;

public class Task implements Runnable {

    private Account account;

    public Task(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            transferMoney(100);
            if (account.getBalance() < 0) {
                System.out.println("NO MONEY!");
            }
        }
    }

    private void transferMoney(int amount) {
        if (account.getBalance() >= amount) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.setBalance(account.getBalance() - amount);
            System.out.println(account.getBalance());
        }
    }

    public static class Account {
        private int balance = 1000;

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }
    }
}