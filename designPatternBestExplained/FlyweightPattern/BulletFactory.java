package flyweight;

import java.util.HashMap;
import java.util.Map;

public class BulletFactory {

    private static Map<String, BulletType> bulletMap = new HashMap<>();

    public static BulletType getBulletType(String texture, int speed, int size) {
        // "bullet.png" + 10 + 30  →  "bullet.png1030"
        String key = texture + speed + size;

        if(!bulletMap.containsKey(key)) {
            bulletMap.put(key, new BulletType(texture, speed, size));
            System.out.println("Created new bullet type: " + key);
        }

        return bulletMap.get(key);
    }


}
