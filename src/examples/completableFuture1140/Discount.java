package examples.completableFuture1140;

import examples.completableFuture1100.DelayUtil;

public class Discount {

    public enum Code {
        NONE(0),
        SILVER(5),
        GOLD(10),
        PLATINUM(15),
        DIAMOND(20);

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    public static String applyDiscount(Quote quote){
        return quote.getShopName() + " price is " + Discount.apply(quote.getPrice(), quote.getDiscountCode());
    }

    public static String apply(double price, Code code) {
        DelayUtil.delay();
        return Double.toString(price * (100 - code.percentage) / 100);
    }


}
