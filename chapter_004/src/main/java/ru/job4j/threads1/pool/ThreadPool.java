package ru.job4j.threads1.pool;

import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

@ThreadSafe
public class ThreadPool {
    private final List<Job> threads = new LinkedList<>();
    private final Queue<Runnable> tasks = new LinkedBlockingQueue<>();
    private int limit = Runtime.getRuntime().availableProcessors();

    public ThreadPool() {
        for (int i = 0; i < limit; i++) {
            threads.add(new Job(tasks));
        }
        for (Job thread : threads) {
            thread.start();
        }
    }

    /**
     * Метод добавляет задачу в блокирующую очередь
     * @param job задача
     */
    public synchronized void work(Runnable job) {
        synchronized (tasks) {
            tasks.add(job);
            tasks.notifyAll();
        }
    }

    /**
     * Завершить работу
     */
    public synchronized void shutdown() throws InterruptedException {
        for (Job thread : threads) {
            thread.toStop();
        }
    }
}