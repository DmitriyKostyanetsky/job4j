package ru.job4j.bank;

public class User implements Comparable<User>{
    private String name;
    private String passport;

    public User() {
    }

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public int compareTo(User o) {
        return this.getName().compareTo(o.getName());
    }
}