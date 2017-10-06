package examples.factory825;

public class ProductFactory {

    public static Product createProduct(String name) {
        switch (name) {
            case "loan":
                return new Loan();
            case "stock":
                return new Stock();
            case "bond" :
                return new Bond();
            default :
                throw new RuntimeException("no such Product" + name);
        }
    }

}
