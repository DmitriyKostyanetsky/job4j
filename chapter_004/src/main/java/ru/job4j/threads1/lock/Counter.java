package ru.job4j.threads1.lock;

public class Counter {
    private int count  = 0;
    private SimpleLock lock = new SimpleLock();

    public int increment() throws InterruptedException {
        lock.lock();
        int newCount = count++;
        System.out.println("count : " + count + " " + Thread.currentThread().getName());
        lock.unlock();
        return newCount;
    }
}