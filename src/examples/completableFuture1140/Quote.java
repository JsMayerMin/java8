package examples.completableFuture1140;

public class Quote {

    private final String shopName;

    private final double price;

    private final Discount.Code discountCode;

    public Quote(String shopName, double price, Discount.Code code) {
        this.shopName = shopName;
        this.price = price;
        this.discountCode = code;
    }

    public static Quote parse(String s) {
        String[] splite = s.split(":");
        String shopName = splite[0];
        double price = Double.parseDouble(splite[1]);
        Discount.Code discountCode = Discount.Code.valueOf(splite[2]);

        return new Quote(shopName, price, discountCode);
    }

    public String getShopName() {
        return shopName;
    }

    public double getPrice() {
        return price;
    }

    public Discount.Code getDiscountCode() {
        return discountCode;
    }
}
