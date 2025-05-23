package designPatters.structural.bridge.code;

public interface PhoneOS {
  void upload(String data);
  void download(String url);
  void display(String data);
}
