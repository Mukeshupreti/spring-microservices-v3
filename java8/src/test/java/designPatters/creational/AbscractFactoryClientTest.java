package designPatters.creational;

import designPatters.creational.abscractFactory.code.Client;
import designPatters.creational.abscractFactory.code.DatabaseFactory;
import designPatters.creational.abscractFactory.code.NetworkFactory;

public class AbscractFactoryClientTest {
  public static void main(String[] args) {
    Client client1 = new Client(new DatabaseFactory());
    client1.communicate();

    Client client2 = new Client(new NetworkFactory());
    client2.communicate();
  }
  
}
