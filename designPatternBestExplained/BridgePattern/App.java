package bridge;

public class App {
    public static void main(String[] args) {

        // these are orthogonal dimensions of variations (shape and rendering methods)
        // we are not changing behavior, we are separating the responsibilities (the drawing logic
        // and how the drawing is rendered)
        // we separate what we do (shape) and how it's done (rendering)

        Shape s1 = new Circle(new VectorRenderer());
        Shape s2 = new Square(new VectorRenderer());
        Shape s3 = new Circle(new RasterRenderer());

        s1.draw();
        s2.draw();
        s3.draw();
    }
}