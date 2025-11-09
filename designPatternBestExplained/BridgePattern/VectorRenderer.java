package bridge;

// concrete implementors
public class VectorRenderer implements Renderer{

    @Override
    public void render(String shape) {
        System.out.println("Vector rendering: " + shape);
    }
}
