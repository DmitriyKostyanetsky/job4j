package ru.job4j.threads1.pool;

import java.util.Queue;

public class Job extends Thread {

    private final Queue<Runnable> tasks;
    private boolean isLock = false;

    public Job(Queue<Runnable> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void run() {
        Runnable job;
        while (!isLock) {
            synchronized (tasks) {
                try {
                    System.out.println("wait " + Thread.currentThread().getName());
                    tasks.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                job = tasks.poll();
                if (job != null) {
                    job.run();
                }
            }
        }
    }

    public synchronized void toStop() throws InterruptedException {
        isLock = true;
        this.interrupt();
        System.out.println(String.format("%s interrupt", this.getName()));
    }
}