package designPatters.behavioural.observer.code;

public class Client {
  public static void main(String[] args) {
    Editor editor = new Editor();
    // create two event listener/subscriber
    EmailNotificationListener emailListener = new EmailNotificationListener();
    LogOpenListener logListener = new LogOpenListener();

    // listener //subscriber to event
    editor.events.subscribe("open", emailListener);
    editor.events.subscribe("save", emailListener);
    editor.events.subscribe("open", logListener);

    editor.openFile("test.jpg");
    editor.saveFile();

    System.out.println();

    editor.events.unsubscribe("save", emailListener);

    editor.openFile("test1.jpg");
    editor.saveFile();
  }
}
