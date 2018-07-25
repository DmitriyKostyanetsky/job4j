package ru.job4j.thread;

import org.junit.Test;
import ru.job4j.threads1.lock.Counter;
import ru.job4j.threads1.lock.ThreadCounter;

public class SimpleLockTest {

    @Test
    public void testLock() throws InterruptedException {
        final Counter counter = new Counter();
        Thread thread1 = new ThreadCounter(counter);
        Thread thread2 = new ThreadCounter(counter);
        Thread thread3 = new ThreadCounter(counter);
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();
    }
}