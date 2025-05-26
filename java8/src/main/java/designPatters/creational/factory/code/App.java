package designPatters.creational.factory.code;



public class App {
    public static void main(String[] args) {
        
        ShapeFactory factory = new ShapeFactory();
        Shape roundFood = factory.getFood("Round");
        Shape cylinderFood = factory.getFood("Cylinder");
        System.out.println(roundFood);
        System.out.println(cylinderFood);
       
    }
}
