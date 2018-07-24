package ru.job4j.thread;

import org.junit.Test;
import ru.job4j.threads1.pool.Task;
import ru.job4j.threads1.pool.ThreadPool;

public class ThreadPoolTest {

    @Test
    public void testThreadPool() throws InterruptedException {
        int size = Runtime.getRuntime().availableProcessors();
        ThreadPool pool = new ThreadPool(size);
        for (int i = 0; i < pool.getThreads().size(); i++) {
            pool.getThreads().get(i).start();
        }
        for (int i = 0; i <= 10; i++) {
            Task task = new Task("Task " + i);
            System.out.println("Added new : " + task.getName());
            pool.work(task);
        }
    }
}