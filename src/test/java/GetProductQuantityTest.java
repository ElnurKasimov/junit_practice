import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class GetProductQuantityTest {
    private Shop shop;

    @BeforeEach
    public void beforeEach() {
        shop = new Shop();
    }

    @Test
    public void testThatGetProductQuantityReturnsMap_A_1() {
        char[] charArray = shop.getProductsNames("A");

        Map<Character, Integer> actual = new Shop().getProductsQuantity(charArray);
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('A', 1);
        expected.put('B', 0);
        expected.put('C', 0);
        expected.put('D', 0);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testThatGetProductQuantityReturnsA1B1C1D1() {
        char[] charArray = shop.getProductsNames("DBCA");

        Map<Character, Integer> actual = new Shop().getProductsQuantity(charArray);
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('A', 1);
        expected.put('B', 1);
        expected.put('C', 1);
        expected.put('D', 1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testThatGetProductQuantityReturnsA0B2C3D1() {
        char[] charArray = shop.getProductsNames("BCCDBC");

        Map<Character, Integer> actual = new Shop().getProductsQuantity(charArray);
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('A', 0);
        expected.put('B', 2);
        expected.put('C', 3);
        expected.put('D', 1);
        Assertions.assertEquals(expected, actual);
    }

}
