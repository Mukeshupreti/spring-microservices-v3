package codereview.userService.refactored;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;

public class UserCache {
    private final ConcurrentMap<String, String> cache = new ConcurrentHashMap<>();

    public String getOrCompute(String key, Function<String, String> mappingFunction) {
        return cache.computeIfAbsent(key, mappingFunction);
    }
}
