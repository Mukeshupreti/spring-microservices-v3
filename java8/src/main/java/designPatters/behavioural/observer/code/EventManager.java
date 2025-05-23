package designPatters.behavioural.observer.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EventManager {
  Map<String, ArrayList<EventListener>> subscribers = new HashMap<>();

  // it takes event types and maintain list of subscribers for those event
  public EventManager(String ... operations) {
    for (String op : operations) {
      subscribers.put(op, new ArrayList<>());
    }
  }
 // add subscriber for that event type
  public void subscribe(String event, EventListener subscriber) {
    ArrayList<EventListener> users = subscribers.get(event);
    if (!users.contains(subscriber)) {
      users.add(subscriber);
    }
  }
  // remove subscriber for that event type
  public void unsubscribe(String event, EventListener subscriber) {
    ArrayList<EventListener> users = subscribers.get(event);
    if (users.contains(subscriber)) {
      users.remove(subscriber);
    }
  }
 // notify subscribers when event happened.
  public void notify(String event, String file) {
    ArrayList<EventListener> users = subscribers.get(event);
    for (EventListener user : users) {
      user.notify(event, file);
    }
  }
}
