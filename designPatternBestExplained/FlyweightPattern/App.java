package flyweight;

public class App {

    public static void main(String[] args) {

        BulletType bulletType = BulletFactory.getBulletType("bullet.png", 10, 5);
        BulletType bulletType2 = BulletFactory.getBulletType("bullet2.png", 20, 10);

        BulletInstance[] bullets = {
                new BulletInstance(100, 200, "UP", bulletType),
                new BulletInstance(105, 210, "UP", bulletType),
                new BulletInstance(110, 220, "UP", bulletType),
                new BulletInstance(110, 220, "UP", bulletType2)
        };

        for(BulletInstance bullet : bullets)
            bullet.draw();
    }
}
