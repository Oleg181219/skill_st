import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Реализуйте вывод номеров одновременно в несколько файлов из нескольких потоков.
 * Оптимизируйте метод padNumber().
 */

public class Loader {
    private static final int REGION_AMOUNT = 100;
    private static final int THREAD_AMOUNT = 7;

    public static void main(String[] args) throws Exception {
        if (THREAD_AMOUNT > 0 && REGION_AMOUNT > 0) {
            long startTime = System.currentTimeMillis();
            char[] letters = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
            int endRegionCode = 0;
            int startRegionCode = 1;
            int count = REGION_AMOUNT - REGION_AMOUNT % THREAD_AMOUNT;

            ExecutorService executorService = Executors.newFixedThreadPool(THREAD_AMOUNT);

            for (int i = 0; i < THREAD_AMOUNT; i++) {
                endRegionCode = count -
                        ((count - endRegionCode) - count / THREAD_AMOUNT);

                executorService.submit(new FileWriter(startRegionCode, endRegionCode, letters, i, startTime));

                System.out.println(new StringBuilder("Thread№-(")
                        .append(i)
                        .append(") started. Regions from - ")
                        .append(startRegionCode)
                        .append(" to - ")
                        .append(endRegionCode)
                        .toString());

                startRegionCode = endRegionCode;
            }

            if (count != REGION_AMOUNT) {
                executorService.submit(new FileWriter(count, REGION_AMOUNT, letters, THREAD_AMOUNT, startTime));

                System.out.println(new StringBuilder("Thread№-(")
                        .append(THREAD_AMOUNT)
                        .append(") started. Regions from - ")
                        .append(count)
                        .append(" to - ")
                        .append(REGION_AMOUNT)
                        .toString());
            }
            executorService.shutdown();
        } else {
            System.out.println("Некорректное количество потоков или количество регионов");
        }

    }
}
