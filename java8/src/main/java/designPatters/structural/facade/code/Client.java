package designPatters.structural.facade.code;

public class Client {
  public static void main(String[] args) {
    NetworkAccessFacade access = new NetworkAccessFacade();
    access.communicate();
  }
}
