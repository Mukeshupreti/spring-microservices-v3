package codereview.userService;

import java.util.HashMap;
import java.util.Map;

//Design issue
//1. Code is not testable
//2. No interface or abstraction
//3, No Dependency injection

//✅ Thread-safety
//✅ Double lookups
//✅ Swallowed exception
//✅ Hardcoded sleep
//✅ SRP violation
//✅ Testability
//✅ Null safety
//✅ Clean code practices

public class UserService {
    // not threadsafe , user concurentHasmap
    // cache should be final
    private Map<String, String> cache = new HashMap<>();

    public String getUserName(String id) {
        if (cache.get(id) != null) {  // called twice ,bad performance.
            return cache.get(id);
        } else {
            String name = fetchFromDB(id);
            cache.put(id, name);
            return name;
        }
    }

    public String fetchFromDB(String id) {
        try {
            Thread.sleep(5000);// make code slow should not used in producton (under load). Harded code value.
        } catch (Exception e) {  // catch specific exception
       // empty exception block . you are swallowing excepton.
        }
        return "User_" + id;
    }
}