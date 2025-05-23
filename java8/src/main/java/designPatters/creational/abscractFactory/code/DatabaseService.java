package designPatters.creational.abscractFactory.code;

public class DatabaseService implements Service {

  @Override
  public String runService() {
    return "Database service running";
  }
  
}
