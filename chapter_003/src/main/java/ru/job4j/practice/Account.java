package ru.job4j.practice;
/**Лишний пробел*/

public class Account {
    /**Лишний пробел. Переменные надо скрыть модификатором private*/
    double values;
    String reqs;

    public Account(double values, String requisites) {
        this.values = values;
        this.reqs = requisites;
    }

    public double getValues() {
        return this.values;
    }
    /**Лишний пробел*/

    public String getReqs () {
        return this.reqs;
    }

    /**Используются переменные класса, хотя есть геттеры*/
    boolean transfer(Account destination, double amount) {
        boolean success = false;
        if (amount > 0 && amount < this.values && destination != null) {
            success = true;
            this.values -= amount;
            destination.values += amount;
        }
        return success;
    }

    public String toString() {
        /**Лучше называть переменные английскими словами*/
        String otvet;
        otvet = "Account{" + "values=" + values + ", reqs='" + reqs + "\\" + "}";
        return otvet;
    }

    public boolean equals(Object o) {
        /**Можно заменить на return (this == o ? true : false);*/
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        /**Лишний пробел*/
        Account account = (Account) o;
        /**Лишний пробел*/
        return this.reqs.equals(account.reqs);
    }

    public int hashCode() {
        return this.reqs.hashCode();
    }
}