package ru.job4j.threads1.executorService;

public class EmailNotification {

    private String subject;
    private String body;

    public void emailTo(User user) {
        subject = "Notification " + user.getUsername() + " to email " + user.getEmail();
        body = "Add a new event to " + user.getUsername();
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }
}