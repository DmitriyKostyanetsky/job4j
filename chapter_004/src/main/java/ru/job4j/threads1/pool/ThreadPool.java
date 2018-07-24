package ru.job4j.threads1.pool;

import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

@ThreadSafe
public class ThreadPool {
    private final List<Thread> threads = new LinkedList<>();
    private final Queue<Runnable> tasks = new LinkedBlockingQueue<>();
    private volatile boolean isLock = true;

    public ThreadPool(int size) {
        for (int i = 0; i < size; i++) {
            Job job = new Job();
            threads.add(job);
        }
    }

    /**
     * Метод добавляет задачу в блокирующую очередь
     * @param job задача
     */
    public void work(Runnable job) {
        if (isLock) {
            synchronized (tasks) {
                tasks.add(job);
                tasks.notify();
            }
        }
    }

    /**
     * Завершить работу
     */
    public void shutdown() {
        System.out.println(String.format("%s shutdown", Thread.currentThread().getName()));
        isLock = false;
    }

    public List<Thread> getThreads() {
        return threads;
    }

    public class Job extends Thread {

        @Override
        public void run() {
            Runnable job;
            while (isLock) {
                synchronized (tasks) {
                    while (tasks.isEmpty()) {
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    job = tasks.poll();
                }
                if (job != null) {
                    job.run();
                }
                if (job == null) {
                    shutdown();
                }
            }
        }
    }
}