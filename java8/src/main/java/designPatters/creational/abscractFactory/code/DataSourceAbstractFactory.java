package designPatters.creational.abscractFactory.code;

public interface DataSourceAbstractFactory {
  Service createService();
  Response createResponse();
}
