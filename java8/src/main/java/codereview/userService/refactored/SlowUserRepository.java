package codereview.userService.refactored;

public class SlowUserRepository implements UserRepository {

    @Override
    public String getUserNameById(String id) throws InterruptedException {
        // Simulated slow DB call
        Thread.sleep(5000);
        return "User_" + id;
    }
}
