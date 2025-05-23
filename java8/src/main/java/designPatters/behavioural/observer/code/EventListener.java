package designPatters.behavioural.observer.code;

public interface EventListener {
  // file event:close/open  , filename
  void notify(String eventType, String file);
}
