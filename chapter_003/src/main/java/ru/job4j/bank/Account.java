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
     * Метод поиска пользователя по паспорту
     * @param passport данные паспорта
     * @return возвращает пользователя
     */
    private User findUser(String passport) {
        User user = new User();
        for (Map.Entry<User, ArrayList<Account>> entry : list.entrySet()) {
            User key = entry.getKey();
            if (key.getPassport().equals(passport)) {
                user = key;
                break;
            }
        }
        return user;
    }

    /**
     * Метод поиска аккаунта по номеру реквизитов
     * @param requisite реквизиты
     * @return возвращает аккаунт
     */
    private Account findAccount(String requisite) {
        Account account = new Account();
        for (Map.Entry<User, ArrayList<Account>> entry : list.entrySet()) {
            ArrayList<Account> value = entry.getValue();
            for (Account acc : value) {
                if (acc.getRequisites() == Integer.parseInt(requisite)) {
                    account = acc;
                    break;
                }
            }
        }
        return account;
    }

    /**
     * Метод переводит деньги со счета одного пользователя на счет другого пользователя
     * @param dest аккаунт получателя
     * @param amount сумма перевода
     * @return возвращает true если перевод удался, false если нет
     */
    private boolean transferTo(Account dest, double amount) {
        boolean result = false;
        if (amount > 0 && amount < this.value) {
            this.value -= amount;
            dest.value += amount;
            result = true;
        }
        return result;
    }

    /**
     * Перечисление денег с одного счёта на другой счёт
     * @param srcPassport паспорт отправителя
     * @param srcRequisite реквизиты отправителя
     * @param destPassport паспорт получателя
     * @param dstRequisite реквизиты получаетеля
     * @param amount сумма
     * @return возвращает true : false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        User userSender = findUser(srcPassport);
        User userDestination = findUser(destPassport);
        Account accountSender = findAccount(srcRequisite);
        Account accountDestination = findAccount(dstRequisite);
        if (accountDestination.getRequisites() != 0 && accountSender.getRequisites() != 0 && userSender.getPassport() != null && userDestination.getPassport() != null) {
            if (accountSender.transferTo(accountDestination, amount)) {
                result = true;
            }
        }
        return result;
    }
}