package ru.job4j.tracker;

import java.util.ArrayList;

/**
 * @author Dmitriy Kostyanetsky (onlywarinfarfuture@gmail.com)
 * @version 1
 * @since 14.04.18
 */
public class StartUI {
    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public static void main(String[] args) throws MenuOutException {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        ArrayList<Integer> range = menu.getActionsKey();
        boolean exit = true;
        do {
            menu.show();
            menu.select(input.ask("Введите команду: ", range));

        } while (!exit);
    }
}