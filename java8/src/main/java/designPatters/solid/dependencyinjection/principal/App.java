package designPatters.solid.dependencyinjection.principal;

public class App {

	public static void main(String[] args) {
		
		DatabaseController controller = new DatabaseController(new OracleDatabase());
		controller.connect();
		controller.disconnect();
		
	}
}
