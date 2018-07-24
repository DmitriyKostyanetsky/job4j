package ru.job4j.threads1;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<T> {
    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();

    private int fullness = 3;

    public synchronized void offer(T value) throws InterruptedException {
        while (queue.size() == fullness) {
            System.out.println(String.format("%s wait", Thread.currentThread().getId()));
            wait();
        }
        if (queue.size() == 0) {
            System.out.println(String.format("%s notify", Thread.currentThread().getId()));
            notifyAll();
        }
        System.out.println(String.format("%s add", Thread.currentThread().getId()));
        queue.add(value);
    }

    public synchronized T poll() throws InterruptedException {
        while (queue.size() == 0) {
            System.out.println(String.format("%s wait", Thread.currentThread().getId()));
            wait();
        }
        if (queue.size() == fullness) {
            System.out.println(String.format("%s notify", Thread.currentThread().getId()));
            notifyAll();
        }
        System.out.println(String.format("%s remove", Thread.currentThread().getId()));
        return queue.remove();
    }
}