package ru.job4j.threads1.executorService;

public class SendMail implements Runnable {

    private EmailNotification email;
    private User user;

    public SendMail(User user) {
        this.user = user;
        email = new EmailNotification();
    }

    private void send(String subject, String body, String email) {}

    @Override
    public void run() {
        email.emailTo(user);
        send(email.getSubject(), email.getBody(), "petr@gmail.com");
        System.out.println(email.getSubject());
        System.out.println(email.getBody());
    }
}