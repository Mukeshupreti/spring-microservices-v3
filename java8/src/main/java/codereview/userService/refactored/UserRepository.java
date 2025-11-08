package codereview.userService.refactored;

public interface UserRepository {
    String getUserNameById(String id) throws InterruptedException;
}
