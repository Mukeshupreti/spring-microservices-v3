package composite;

import java.util.ArrayList;
import java.util.List;

public class ShapeGroup implements Shape {

    private List<Shape> children = new ArrayList<>();

    public void add(Shape shape) {
        this.children.add(shape);
    }

    public void remove(Shape shape) {
        this.children.remove(shape);
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Group of Shapes:");
        for(Shape shape : this.children)
            shape.draw();
    }
}
