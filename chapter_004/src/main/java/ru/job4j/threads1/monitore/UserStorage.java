package ru.job4j.threads1.monitore;

import net.jcip.annotations.ThreadSafe;

import java.util.ArrayList;
import java.util.List;

@ThreadSafe
public class UserStorage {

    private List<User> list = new ArrayList<>();

    public synchronized boolean add(User user) {
        list.add(user);
        return true;
    }

    public synchronized boolean update(User user) {
        for (User value : list) {
            if (value.equals(user)) {
                value = user;
                return true;
            }
        }
        return false;
    }

    public synchronized boolean delete (User user) {
        list.remove(user);
        return true;
    }

    public synchronized boolean transfer(int fromId, int toId, int amount) {
        User from = null;
        User to = null;
        for (User value : list) {
            if (value.getId() == fromId) {
                from = value;
            }
            if (value.getId() == toId) {
                to = value;
            }
        }
        if (from != null && to != null && from.getAmount() > amount) {
            from.setAmount(from.getAmount() - amount);
            to.setAmount(to.getAmount() + amount);
            System.out.println(from.getAmount() + " " + to.getAmount());
            return true;
        }
        return false;
    }

    public List<User> getList() {
        return list;
    }
}