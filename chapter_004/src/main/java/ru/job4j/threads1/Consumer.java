package ru.job4j.threads1;

public class Consumer extends Thread {
    private SimpleBlockingQueue<Integer> queue;

    public Consumer(SimpleBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            queue.poll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}