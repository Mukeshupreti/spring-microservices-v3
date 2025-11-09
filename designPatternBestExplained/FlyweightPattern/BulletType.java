package flyweight;

// Concrete Flyweight
public class BulletType implements Bullet {
    private final String texture; // e.g., "bullet.png
    private final int speed;
    private final int size;

    public BulletType(String texture, int speed, int size) {
        this.texture = texture;
        this.speed = speed;
        this.size = size;
    }

    @Override
    public void render(int x, int y, String direction) {
        System.out.println("Rendering bullet with texture '" + texture +
                "' at (" + x + ", " + y + ") moving " + direction +
                " with speed " + speed + " and size " + size);
    }
}
