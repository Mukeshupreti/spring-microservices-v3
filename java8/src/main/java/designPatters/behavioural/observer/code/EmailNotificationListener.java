package designPatters.behavioural.observer.code;

public class EmailNotificationListener implements EventListener {

  @Override
  public void notify(String eventType, String file) {
    System.out.println("EmailNotificationListener: " + eventType + " performed on file " + file);
  }
  
}
