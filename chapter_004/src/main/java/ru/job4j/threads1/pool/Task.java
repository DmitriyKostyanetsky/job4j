package ru.job4j.threads1.pool;

public class Task implements Runnable {

    private String name;

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        System.out.println("During : " + name + " : " + Thread.currentThread().getName());
    }
}