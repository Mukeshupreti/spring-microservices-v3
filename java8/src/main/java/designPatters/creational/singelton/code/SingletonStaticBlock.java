package designPatters.creational.singelton.code;
public class SingletonStaticBlock {
  private static SingletonStaticBlock instance;

  static {
    instance = new SingletonStaticBlock();
  }

  private SingletonStaticBlock() {

  }

  public static SingletonStaticBlock getInstance() {
    return instance;
  }
}
