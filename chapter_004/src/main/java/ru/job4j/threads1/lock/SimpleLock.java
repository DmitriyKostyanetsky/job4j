package ru.job4j.threads1.lock;

import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class SimpleLock {
    private boolean isLock = true;

    public synchronized void lock() throws InterruptedException {
        System.out.println("lock " + Thread.currentThread().getName());
        while (!isLock) {
            System.out.println("wait " + Thread.currentThread().getName());
            wait();
        }
        isLock = false;
    }

    public synchronized void unlock() {
        System.out.println("unlock " + Thread.currentThread().getName());
        isLock = true;
        notify();
    }
}