package visitor;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(10));
        shapes.add(new Rectangle(5, 3));

        var areaCalculator = new AreaCalculator();

        for(Shape s : shapes)
            s.accept(areaCalculator);

    }
}
