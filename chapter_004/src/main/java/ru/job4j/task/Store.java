package ru.job4j.task;

import java.util.List;

public class Store {
    private static User temp;
    private Info info = new Info();

    public Info diff(List<User> current, List<User> next) {
        info = info.deleted(current, next);
        System.out.println("Added: " + info.addCount + " Changed: " + info.chCount + " Deleted: " + info.remCount);
        return info;
    }

    private class Info {
        private int addCount = 0;
        private int chCount = 0;
        private int remCount = 0;

        private Info() {}

        private Info(int addCount, int chCount, int remCount) {
            this.addCount = addCount;
            this.chCount = chCount;
            this.remCount = remCount;
        }

        private Info deleted(List<User> current, List<User> next) {
            for (User value : current) {
                if (!next.contains(value)) {
                    remCount++;
                    continue;
                }
                if (!value.name.equals(temp.name)) {
                    chCount++;
                }
            }
            addCount = Math.abs(current.size() - next.size()) + remCount;
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

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof User)) {
                return false;
            }
            User user = (User) obj;
            temp = user;
            return Integer.compare(id, user.id) == 0;
        }
    }
}