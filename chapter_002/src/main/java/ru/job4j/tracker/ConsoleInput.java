package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scan = new Scanner(System.in);

    public String ask(String question) {
        System.out.println(question);
        return scan.next();
    }

    public int ask(String question, ArrayList<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Out of menu range");
        }
        return key;
    }
}