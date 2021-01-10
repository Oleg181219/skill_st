import org.redisson.Redisson;
import org.redisson.api.RDeque;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.Config;

public class RedisStorage {
    private RedissonClient redissonClient;
    private RDeque<Integer> usersId;
    public static final int USERS_COUNT = 20;

    public void initialisation() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        try {
            redissonClient = Redisson.create(config);
        } catch (RedisConnectionException e) {
            e.printStackTrace();
        }
        usersId = redissonClient.getDeque("users");
    }

    public void initialisationData() {
        for (int i = 0; i < USERS_COUNT; i++) {
            usersId.add(i);
        }
    }

    public void addLastUser(int userId) {
        usersId.addLast(userId);
    }

    public void pushUserFirst(int userId) {
        usersId.push(userId);
    }

    public Integer peekFirstUser() {
        return usersId.peekFirst();
    }

    public Integer removeFirstUser() {
        return usersId.removeFirst();
    }

}