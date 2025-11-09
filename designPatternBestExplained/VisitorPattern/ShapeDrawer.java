package visitor;

public class ShapeDrawer implements ShapeVisitor {
    @Override
    public void visit(Circle circle) {
        System.out.println("Drawing the circle on the screen " + circle.getRadius());
    }

    @Override
    public void visit(Rectangle rectangle) {
        System.out.println("Drawing the rectangle on the screen " +
                rectangle.getWidth() + " - " + rectangle.getHeight());
    }
}
