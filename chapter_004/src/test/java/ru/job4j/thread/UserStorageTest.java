package ru.job4j.thread;

import org.junit.Test;
import ru.job4j.treads.monitore.ThreadTransfer;
import ru.job4j.treads.monitore.User;
import ru.job4j.treads.monitore.UserStorage;

public class UserStorageTest {

    @Test
    public void whenFirstTransfer50ToSecondThen250() throws InterruptedException {
        UserStorage storage = new UserStorage();
        storage.add(new User(1, 100));
        storage.add(new User(2, 200));
        Thread one = new ThreadTransfer(storage);
        Thread two = new ThreadTransfer(storage);
        one.start();
        two.start();
        one.join();
        two.join();
        storage.transfer(1, 2, 50);
    }
}