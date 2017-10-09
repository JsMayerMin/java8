package examples.chapter11_completable_future.completableFuture1100;

import java.util.Random;

public class DelayUtil {

    private static Random random = new Random();

    public static void delay() {
        delay(1000L);
    }
    public static void delay(long delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException ex) {
            throw new RuntimeException();
        }
    }

    public static void randomDeplay() {
        int delay = 500 + random.nextInt(2000);
        delay(delay);
    }

}
