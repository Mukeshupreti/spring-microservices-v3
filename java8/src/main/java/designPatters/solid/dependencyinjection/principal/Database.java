package designPatters.solid.dependencyinjection.principal;

// this is the abstract layer
public interface Database {
	public void connect();
	public void disconnect();
}
