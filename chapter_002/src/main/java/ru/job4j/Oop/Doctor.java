package ru.job4j;

public class Doctor extends Profession {
    public Diagnose heal(Patient patient) {
        Diagnose diagnose = new Diagnose();
        return diagnose;
    }
}