package examples.completableFuture1100;

import java.util.Random;

public class Shop {

    private String name;

    public String getName() {
        return this.name;
    }

    private Random random = new Random();

    public Shop(String name) {
        this.name = name;
    }

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    private double calculatePrice(String product) {
        DelayUtil.delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

}
