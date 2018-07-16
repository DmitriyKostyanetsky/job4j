package ru.job4j.treads.condition;

public class Visibility implements Runnable{
    private static boolean stop;

    @Override
    public void run() {
        System.out.println("wait");
        while (true) {
            if (stop) {
                System.out.println("stop");
                break;
            }
        }
    }

    public void aVoid() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("changed");
        stop = true;
    }
}