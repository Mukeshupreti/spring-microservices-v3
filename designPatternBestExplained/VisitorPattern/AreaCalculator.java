package visitor;

import java.net.StandardSocketOptions;

public class AreaCalculator implements ShapeVisitor {
    @Override
    public void visit(Circle circle) {
        double area = Math.PI * circle.getRadius() * circle.getRadius();
        System.out.println("Total are of the circle: " + area);
    }

    @Override
    public void visit(Rectangle rectangle) {
        System.out.println("Total are of the rectangle: " +
                rectangle.getHeight() * rectangle.getWidth());
    }
}
