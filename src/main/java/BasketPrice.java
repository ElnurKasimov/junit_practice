import java.util.Map;

public class BasketPrice {
    double calculateTotalCost(String string) throws IllegalArgumentException {
        double result = 0;
        Map<Character, Integer> products = new Parser().getProductsQuantity(string);
        for (Map.Entry<Character , Integer> entry: products.entrySet()) {
            result+=new ProductCost().getProductCost(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
