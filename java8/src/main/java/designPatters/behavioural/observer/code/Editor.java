package designPatters.behavioural.observer.code;

// editor maintainer EventManagers and operation/event
public class Editor {
  public EventManager events = new EventManager("open", "save");
  String file = "";

  void openFile(String filename) {
    this.file = filename;
    events.notify("open", file);
  }

  void saveFile() {
    if (file != "") {
      events.notify("save", file);
    }
  }
}
