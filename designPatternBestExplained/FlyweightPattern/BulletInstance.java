package flyweight;

// Represents each active bullet in the game world
public class BulletInstance {

    private final int x;
    private final int y;
    private final String direction;
    private final BulletType type;

    public BulletInstance(int x, int y, String direction, BulletType type) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.type = type;
    }

    public void draw() {
        this.type.render(this.x, this.y, this.direction);
    }
}
