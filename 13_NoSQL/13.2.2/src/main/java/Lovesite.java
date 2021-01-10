import java.util.Random;

public class Lovesite {

    private static final Random RND = new Random();

    public static void main(String[] args) {

        RedisStorage redisStorage = new RedisStorage();
        redisStorage.initialisation();
        redisStorage.initialisationData();

        for (; ; ) {
            for (int i = 1; i <= RedisStorage.USERS_COUNT; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("На главной странице показываем пользователя: " + redisStorage.peekFirstUser());
                redisStorage.addLastUser(redisStorage.removeFirstUser());
                if ((i % getRnd()) == 0) {
                    System.out.println("Пользователь " + i + " оплатил платную услугу");
                    redisStorage.pushUserFirst(i);
                }
            }
            try {
                System.out.println("=====================================================");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private static int getRnd() {
        return RND.nextInt(RedisStorage.USERS_COUNT) + 1;
    }
}
