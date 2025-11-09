package visitor;

public interface Shape {
    void accept(ShapeVisitor visitor);
}
