package examples.completableFuture1100;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class ExecuteService {

    //동시성(Concurrency)과 병렬성(Parallelism)에 대해서 생각해보자.
    List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"));

    private final Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100)
            , new ThreadFactory() {
                public Thread newThread(Runnable r) {
                    Thread t = new Thread(r);
                    t.setDaemon(true);
                    return t;
                }
            });

    private final Executor executorWithLambda = Executors.newFixedThreadPool(Math.min(shops.size(), 100)
            , (Runnable r) -> {
                Thread t = new Thread(r);
                t.setDaemon(true);
                return t;
            }
            );


    public static void startCompleteFutureExample() {
        AsyncShop shop = new AsyncShop("BestShop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + invocationTime + " msecs");

        //제품의 가격을 계산하는 동안
        // 다른 상점 검색 등 다른 작업 수행
        doSomethingElse();
        try {
            double price = futurePrice.get();
            System.out.printf("Price is %.2f", price);
        } catch (Exception ex) {
            throw new RuntimeException();
        }

    }

    public static void doSomethingElse() {
        return;
    }

    //순차적으로 api를 요청한다. 가장 오래 걸림.
    public List<String> findPrices(String product) {
        return shops.stream()
                .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    //병렬적으로 api를 요청한다.
    public List<String> findPricesByParallel(String product) {
        //ForkJoinPool의 commonPool을 이용해서 vCpu 갯수만큼 병렬화를 진행한다.
        return shops.parallelStream()
                .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }


    //병렬적 수행은 cpu에게 맡기고 thread를 동시에 생성한다.
    //findPricesByParallel, Concurrent모두 Runtime.getRuntime().availableProcessors() 가 반환하는 스레드 수를 사용면서
    //비슷한 결과가 나온다는 점을 파악할 수 있다.
    public List<String> findPricesByConcurrent(String product) {
        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getName() + " price is " + shop.getPrice(product)))
                .collect(Collectors.toList());

        //모든 비동기 동작이 끝나길 기다린다.
        return priceFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

    /*
        적절한 cpu수 찾기  by Java concurrency in Practice http://mng.bz/979c
        ThreadNum = CpuNum * CpuUsage * (1 + W/C)
        ThreadNum : Runtime.getRuntime().availableProcessors() 가 반환하는 코어수
        CpuNum : 0과 1 사이값을 갖는 cpu 활용비율
        W/C는 대기시간과 계산시간의 비율
     */

    public List<String> findPricesByConcurrentWithCustomExecutor(String product) {
        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop ->
                        CompletableFuture.supplyAsync(
                                () -> shop.getName() + " price is " + shop.getPrice(product), executorWithLambda)
                )
                .collect(Collectors.toList());

        //모든 비동기 동작이 끝나길 기다린다.
        return priceFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

}
