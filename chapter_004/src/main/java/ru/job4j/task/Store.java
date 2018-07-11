package ru.job4j.task;

import java.util.List;

public class Store {
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
            for (int i = 0; i < current.size(); i++) {
                for (int j = 0; j < next.size(); j++) {
                    if (current.get(i).equals(next.get(j))) {
                        if (!current.get(i).name.equals(next.get(j).name)) {
                            chCount++;
                        }
                        break;
                    }
                    if (!current.get(i).equals(next.get(j)) && j + 1 == next.size()) {
                        remCount++;
                    }
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
            return Integer.compare(id, user.id) == 0;
        }
    }
}