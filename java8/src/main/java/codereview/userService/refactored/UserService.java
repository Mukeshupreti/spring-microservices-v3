package codereview.userService.refactored;

//Split responsibilities:
//
//UserRepository → fetches from DB
//
//UserCache → handles caching
//
//UserService → business logic
public class UserService {

    private final UserRepository repository;
    private final UserCache cache;

    public UserService(UserRepository repository, UserCache cache) {
        this.repository = repository;
        this.cache = cache;
    }

    public String getUserName(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("id cannot be null or empty");
        }

        try {
            return cache.getOrCompute(id, this::fetchSafe);
        } catch (RuntimeException e) {
            throw new IllegalStateException("Failed to fetch username for id: " + id, e);
        }
    }

    private String fetchSafe(String id) {
        try {
            return repository.getUserNameById(id);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();  // 🔥 Critical Sonar rule
            throw new RuntimeException("Thread interrupted while fetching from DB", e);
        }
    }
}
