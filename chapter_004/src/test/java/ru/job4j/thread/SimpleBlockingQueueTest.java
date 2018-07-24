package ru.job4j.thread;

import org.junit.Test;
import ru.job4j.threads1.Consumer;
import ru.job4j.threads1.Producer;
import ru.job4j.threads1.SimpleBlockingQueue;

public class SimpleBlockingQueueTest {

    @Test
    public void testBlockingQueue() throws InterruptedException {
        SimpleBlockingQueue<Integer> simpleBlockingQueue = new SimpleBlockingQueue<>();
        Thread consumer = new Consumer(simpleBlockingQueue);
        Thread producer = new Producer<>(simpleBlockingQueue, 3);
        consumer.start();
        producer.start();
        consumer.join();
        producer.join();
    }
}