package bridge;

// concrete implementors
public class RasterRenderer implements Renderer{

    @Override
    public void render(String shape) {
        System.out.println("Raster rendering: " + shape);
    }
}
