package examples.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ExecuteService {

    final static Map<String, Supplier<Product>> java8Factory = new HashMap<>();

    static {
        java8Factory.put("loan", Loan::new);
        java8Factory.put("stock", Stock::new);
        java8Factory.put("bond", Bond::new);
    }

    public static void oldJavaExecute() {
        Product a = ProductFactory.createProduct("loan");
    }

    public static void java8Execute() {
        Supplier<Product> loanSupplier = Loan::new;
        Loan loan = (Loan) loanSupplier.get();
    }

    public static Product createProduct(String name) {
        Supplier<Product> p = java8Factory.get(name);
        if (p != null)
            return p.get();
        throw new IllegalArgumentException("No Such Product " + name);
    }

}
