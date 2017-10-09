package examples.completableFuture1140;

import examples.completableFuture1100.DelayUtil;

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

    public String getPrice(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[
                random.nextInt(Discount.Code.values().length)
                ];
        return String.format("%s:%.2f:%s", name, price, code);
    }

    private double calculatePrice(String product) {
        DelayUtil.delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

}
