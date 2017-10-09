package examples.chapter11_completable_future.completableFuture1140;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExecuteService {

    private static Random random = new Random();

    List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"));

    Executor customExecutor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), (Runnable r) ->{
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    });


    public List<String> findPrices(String product) {
        return shops.stream()
                .map(shop -> shop.getPrice(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(Collectors.toList());
    }

    public List<String> findPricesWithCompletableFuture(String product) {
        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), customExecutor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), customExecutor)))
                .collect(Collectors.toList());

        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

    }

    //CompletableFuture.thenCombine 예제
    public Future<Double> exampleCombinedCompletableFuture(String product) {
        Future<Double> futurePriceUSC = CompletableFuture.supplyAsync(() -> getPrice())
                .thenCombine(
                        CompletableFuture.supplyAsync(() -> getRate()),
                        (price, rate) -> price * rate
                );
        //합치는 연산 자체를 Async하게 진행하고 싶으면 thenCombineAsync를 사용한다.
        return futurePriceUSC;
    }

    public static double getPrice() {
        return random.nextDouble();
    }

    public static double getRate() {
        return random.nextDouble();
    }

    //종료과정을 리팩토링해보자
    //반환되는 결과를 즉시 확인하고 최종적으로 다 확인했으면 종료한다.

    public void findResultASAP() {
        //CompletableFuture는 Collection을 지원하지 않기 때문에 array로 변환하는 과정을 만든다.

        CompletableFuture[] futures = findPricesStream("myPhone").map(f->f.thenAccept(System.out::println))
                .toArray(size -> new CompletableFuture[size]);
        CompletableFuture.allOf(futures).join();

    }

    public Stream<CompletableFuture<String>> findPricesStream(String product) {
        return shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), customExecutor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), customExecutor)));
    }




}
