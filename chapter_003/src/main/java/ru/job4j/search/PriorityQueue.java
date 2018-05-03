package ru.job4j.search;

import java.util.Comparator;
import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод вставляет в нужную позицию элемент
     * Позиция определяется по полю приоритет
     * @param task задача
     */
    public void put(Task task) {
        tasks.add(0, task);
        if (tasks.size() > 1) {
            tasks.sort(Comparator.comparing(Task::getPriority));
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
