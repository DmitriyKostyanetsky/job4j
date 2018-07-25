package ru.job4j.threads1.lock;

public class ThreadCounter extends Thread {
    private final Counter counter;

    public ThreadCounter(final Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            counter.increment();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}