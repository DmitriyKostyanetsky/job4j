package ru.job4j.treads.monitore;

public class ThreadTransfer extends Thread {
    private UserStorage storage;

    public ThreadTransfer(UserStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        storage.transfer(1, 2, 50);
    }
}