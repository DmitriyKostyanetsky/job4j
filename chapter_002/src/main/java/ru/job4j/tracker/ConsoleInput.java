package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements ru.job4j.tracker.Input {
    private Scanner scan = new Scanner(System.in);

    public String ask(String question) {
        System.out.println(question);
        return scan.next();
    }
}