package designPatters.creational.singelton.code;
public class SingletonBillPugh {
  private SingletonBillPugh() {

  }

  private static class InnerStaticClass {
    private static final SingletonBillPugh billPughInstance = new SingletonBillPugh();
  }

  public static SingletonBillPugh getInstance() {
    return InnerStaticClass.billPughInstance;
  }
  
}
