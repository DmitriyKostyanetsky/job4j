package ru.job4j.bank;

import java.util.*;

public class Account {
    private Map<User, ArrayList<Account>> list = new TreeMap<>();
    private double value;
    private int requisites;

    public Account() {}

    public Account(double value, int requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public double getValue() {
        return value;
    }

    public int getRequisites() {
        return requisites;
    }

    /**
     * Добавление пользователя.
     * @param user пользователь
     */
    public void addUser(User user) {
        list.put(user, new ArrayList<>());
    }

    /**
     * Удаление пользователя.
     * @param user пользователь
     */
    public void deleteUser(User user) {
        list.remove(user);
    }

    /**
     * Добавить счёт пользователю.
     * @param passport паспорт
     * @param account аккаунт
     */
    public void addAccountToUser(String passport, Account account) {
        for (Map.Entry<User, ArrayList<Account>> entry : list.entrySet()) {
            User key = entry.getKey();
            if (key.getPassport().equals(passport)) {
                list.get(key).add(account);
                break;
            }
        }
    }

    /**
     * Удалить один счёт пользователя.
     * @param passport паспорт
     * @param account аккаунт
     */
    public void deleteAccountFromUser(String passport, Account account) {
        for (Map.Entry<User, ArrayList<Account>> entry : list.entrySet()) {
            User key = entry.getKey();
            if (key.getPassport().equals(passport)) {
                list.get(key).remove(account);
                break;
            }
        }
    }

    /**
     * Получить список счетов для пользователя.
     * @param passport паспорт
     * @return возвращает список счетов
     */
    public List<Account> getUserAccounts (String passport) {
        List<Account> result = new ArrayList<>();
        for (Map.Entry<User, ArrayList<Account>> entry : list.entrySet()) {
            User key = entry.getKey();
            ArrayList<Account> value = entry.getValue();
            if (key.getPassport().equals(passport)) {
                result.addAll(value);
                break;
            }
        }
        return result;
    }

    /**
     * Перечисления денег с одного счёта на другой счёт
     * @param srcPassport паспорт отправителя
     * @param srcRequisite реквизиты отправителя
     * @param destPassport паспорт получателя
     * @param dstRequisite реквизиты получаетеля
     * @param amount сумма
     * @return возвращает true : false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        int changedValue = 0;
        int exit = 0;
        if (amount > 0 && Integer.parseInt(dstRequisite) != 0) {
            while (exit == 0) {
                for (Map.Entry<User, ArrayList<Account>> entry : list.entrySet()) {
                    User key = entry.getKey();
                    ArrayList<Account> value = entry.getValue();
                    for (Account account : value) {
                        if (key.getPassport().equals(srcPassport) && account.getRequisites() == Integer.parseInt(srcRequisite) && amount < account.getValue()) {
                            value.set(value.indexOf(account), new Account(account.getValue() - amount, account.getRequisites()));
                            list.put(key, value);
                            changedValue++;
                        }
                        if (key.getPassport().equals(destPassport) && account.getRequisites() == Integer.parseInt(dstRequisite) && changedValue != 0) {
                            value.set(value.indexOf(account), new Account(account.getValue() + amount, account.getRequisites()));
                            list.put(key, value);
                            result = true;
                            exit++;
                            break;
                        }
                        if (key.getPassport().equals(srcPassport) && account.getRequisites() == Integer.parseInt(srcRequisite) && amount > account.getValue()) {
                            exit++;
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
}