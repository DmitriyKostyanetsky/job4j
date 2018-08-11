package ru.job4j.thread;

import org.junit.Test;
import ru.job4j.threads1.executorService.SendMail;
import ru.job4j.threads1.executorService.User;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmailNotificationTest {

    @Test
    public void testEmailNotification() {
        User user = new User("Ivan", "ivan@gmail.com");
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        service.submit(new SendMail(user));
        service.shutdown();
    }
}