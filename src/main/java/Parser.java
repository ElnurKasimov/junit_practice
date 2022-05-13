import java.util.HashMap;
import java.util.Map;

public class Parser {

    public Map<Character, Integer> getProductsQuantity(String string) throws IllegalArgumentException {
        Map<Character, Integer> quantityMap = new HashMap<>();
        char[] names = string.toCharArray();
        if (string.isEmpty())
            throw new IllegalArgumentException("input should be letter A, B, C, D only");
        for (char c : names) {
            if (!(c == 'A' || c == 'B' || c == 'C' || c == 'D')) {
                throw new IllegalArgumentException("input should be letter A, B, C, D only");
            }
        }
        Character[] productName = {'A', 'B', 'C', 'D'};
        Integer[] productQuantity = {0, 0, 0, 0};
        for (int i = 0; i < names.length; i++) {
            switch (names[i]) {
                case 'A': {
                    productQuantity[0]++;
                    break;
                }
                case 'B': {
                    productQuantity[1]++;
                    break;
                }
                case 'C': {
                    productQuantity[2]++;
                    break;
                }
                case 'D': {
                    productQuantity[3]++;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            quantityMap.put(productName[i], productQuantity[i]);
        }
        return quantityMap;
    }
}
