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
            try {
                synchronized (tasks) {
                    while (this.tasks.size() == 0) {
                        tasks.wait();
                    }
                    if (this.tasks.size() != 0) {
                        tasks.notifyAll();
                    }
                    job = tasks.poll();
                    job.run();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void toStop() throws InterruptedException {
        isLock = true;
        this.interrupt();
        System.out.println(String.format("%s interrupt", this.getName()));
    }
}