package designPatters.creational.abscractFactory.code;

public class App {

    // abstractfactory (DataSourceAbstractFactory) --- two implemenatation  DatabaseFactory NetworkFactory
    // service and response are two factory which provide service (network/database) response (network /database)

    public static void main(String[] args) {
        Client client1 = new Client(new DatabaseFactory());
        client1.communicate();
    
        Client client2 = new Client(new NetworkFactory());
        client2.communicate();
      }
}
