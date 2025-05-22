package designPatters.creational;


import designPatters.Shape;
import designPatters.ShapeFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShapeFactoryTest {
  ShapeFactory factory = new ShapeFactory();
  Shape roundFood = factory.getFood("Round");
  Shape cylinderFood = factory.getFood("Cylinder");
  
  @Test
  void factoryMethodTest() {
    assertEquals("Round", roundFood.getShape());
    assertEquals("Cylinder", cylinderFood.getShape());
  }
}
