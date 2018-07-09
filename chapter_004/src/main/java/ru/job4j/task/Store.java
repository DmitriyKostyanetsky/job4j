package ru.job4j.task;

import java.util.Iterator;
import java.util.List;

public class Store {
    private Info info = new Info();

    public Info diff(List<User> current, List<User> next) {
        info = info.changed(current, next);
        System.out.println("Added: " + info.addCount + " Changed: " + info.chCount + " Deleted: " + info.remCount);
        return info;
    }

    private class Info {
        private Iterator<User> curIterator;
        private Iterator<User> nextIterator;
        private int addCount = 0;
        private int chCount = 0;
        private int remCount = 0;

        private Info() {}

        private Info(int addCount, int chCount, int remCount) {
            this.addCount = addCount;
            this.chCount = chCount;
            this.remCount = remCount;
        }

        private Info changed(List<User> current, List<User> next) {
            curIterator = current.iterator();
            nextIterator = next.iterator();
            while (curIterator.hasNext() && nextIterator.hasNext()) {
                if (!curIterator.next().equals(nextIterator.next())) {
                    chCount++;
                }
            }
            addCount = next.size() - current.size();
            if (addCount < 0) {
                remCount = Math.abs(addCount);
            }
            return new Info(addCount, chCount, remCount);
        }
    }

    static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}