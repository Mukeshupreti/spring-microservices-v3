package com.example.sonarpractice.notification;
public class Main {
    public static void main(String[] args) {
        NotificationService svc = new NotificationService();
        svc.send(new EmailNotifier(), "hello@example.com", "Test", "Hi");
    }
}
interface Notifier { void notify(String to, String subject, String body); }
class EmailNotifier implements Notifier {
    public void notify(String to, String subject, String body){
        System.out.println("Sending EMAIL to " + to + ": " + subject);
    }
}
class NotificationService {
    public void send(Notifier notifier, String to, String subject, String body){
        notifier.notify(to, subject, body);
    }
}
