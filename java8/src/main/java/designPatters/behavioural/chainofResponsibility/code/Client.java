package designPatters.behavioural.chainofResponsibility.code;

public class Client {
  public static void main(String[] args) {
    // initilize all the three handler
    AuthenticationHandler auth = new AuthenticationHandler("12345");
    ContentTypeHandler type = new ContentTypeHandler("json");
    PayloadHandler payload = new PayloadHandler("Body: {\"username\" = \"john\"}");

    // build a chain auth->type->payload
    auth.next = type;
    type.next = payload;

    // calling   chain from auth
    String withAuthentication = auth.addHandler("Headers with authentication");
    System.out.println(withAuthentication);

    System.out.println("-------------------------------------------------------");
    // calling   chain from type
    String withoutAuthentication = type.addHandler("Headers without authentication");
    System.out.println(withoutAuthentication);
  }
}
