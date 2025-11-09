package composite;

public class App {

    public static void main(String[] args) {

        Shape circle = new Circle();
        Shape square = new Square();

        // leaves - they are the end nodes — they do not have children
        circle.draw();
        square.draw();

        System.out.println(" +++++++++++++++++++++++ ");
        ShapeGroup group = new ShapeGroup();
        group.add(circle);
        group.add(square);
        group.draw();

        System.out.println(" +++++++++++++++++++++++ ");
        ShapeGroup bigGroup = new ShapeGroup();
        bigGroup.add(circle);
        bigGroup.add(group);
        bigGroup.draw();
    }
}
