package examples.chapter11_completable_future.completableFuture1100;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class AsyncShop {

    private String name;

    private Random random = new Random();

    public AsyncShop(String name) {
        this.name = name;
    }

    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            try {
                double price = calculatePrice(product);
                futurePrice.complete(price);
            } catch (Exception threadEx) {
                futurePrice.completeExceptionally(threadEx);
            }
        }
        ).start();
        return futurePrice;
    }

    //getPriceAsync와 동일한 구현이다.
    public Future<Double> getPriceAync8Style(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    private double calculatePrice(String product) {
        DelayUtil.delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

}
