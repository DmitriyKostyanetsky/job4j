package ru.job4j.thread;

import org.junit.Test;
import ru.job4j.treads.condition.Task;

public class ThreadTest {

    @Test
    public void testThread() throws InterruptedException {
        Task task = new Task(new Task.Account());
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}