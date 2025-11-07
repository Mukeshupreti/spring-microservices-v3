package com.example.sonarpractice.notification;

import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception {
        NotificationService svc = new NotificationService();
        svc.send(new EmailNotifier(), "user@example.com", "Welcome", "Hello!");
        svc.send(new SMSNotifier(), "+491234567", "Code", "1234");
        svc.shutdown();
    }
}

interface Notifier { void notify(String to, String subject, String body) throws Exception; }

class EmailNotifier implements Notifier {
    public void notify(String to, String subject, String body){
        System.out.println("[EMAIL] to="+to+" subject="+subject+" body="+body);
    }
}

class SMSNotifier implements Notifier {
    public void notify(String to, String subject, String body){
        System.out.println("[SMS] to="+to+" msg="+body);
    }
}

class NotificationService {
    private final ExecutorService exec = Executors.newSingleThreadExecutor();
    public void send(Notifier notifier, String to, String subject, String body){
        exec.submit(() -> {
            int attempts=0;
            while(attempts<3){
                try{
                    notifier.notify(to, subject, body);
                    return;
                }catch(Exception e){
                    attempts++;
                    try{ Thread.sleep(100); }catch(Exception ex){}
                }
            }
            System.err.println("Failed to send to " + to);
        });
    }
    public void shutdown(){ exec.shutdown(); }
}
