package ru.job4j.threads;

public class Producer<Integer> extends Thread {

    private SimpleBlockingQueue<Integer> queue;
    private Integer number;

    public Producer(SimpleBlockingQueue<Integer> queue, Integer number) {
        this.queue = queue;
        this.number = number;
    }

    @Override
    public void run() {
        try {
            queue.offer(number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}