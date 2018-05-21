package ru.job4j.department;

public class Departments{
    String name;

    public Departments(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object ob){
        if (this == ob) {
            return true;
        }
        if (!(ob instanceof Departments)) {
            return false;
        }
        return name.equals(((Departments)ob).getName());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}