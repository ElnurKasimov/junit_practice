import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class calculateTotalCostTest {
    private Shop shop;

    @BeforeEach
    public void beforeEach() {
        shop = new Shop();
        shop.create('A', 3, 1.25, 3);
        shop.create('B', 0, 4.25, 0);
        shop.create('C', 6, 1., 5);
        shop.create('D', 0, 0.75, 0);
    }

    @Test
    public void testThatCalculateTotalCostInvalidInputDHandledCorrectly() {
        String[] invalidInputs = {
                null,
                "",
                " ",
                "7",
                "3.1",
                "c",
                "A B",
                " D",
                "3DDD",
                "A+B",
                "B "
        };
        for (String str : invalidInputs) {
            Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> shop.calculateTotalCost(str));
        }
    }

    @Test
    public void testThatCalculateTotalCostReturns_PromotionalPrice_For_A() {
        double actual = shop.calculateTotalCost("A");
        double expected = 3.0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testThatCalculateTotalCostReturns_ThreePromotionalPrice_For_AAA() {
        double actual = shop.calculateTotalCost("AAA");
        double expected = 9.0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testThatCalculateTotalCostReturns_DoublePrice_For_BB() {
        double actual = shop.calculateTotalCost("BB");
        double expected = 8.5;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testThatCalculateTotalCostReturns_PriceAndTreePromotionalPrice_For_AAAA() {
        double actual = shop.calculateTotalCost("AAAA");
        double expected = 4.25;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testThatCalculateTotalCostWQorksRightFor_ABCD() {
        double actual = shop.calculateTotalCost("ABCD");
        double expected = 13.;
        Assertions.assertEquals(expected, actual);
    }
}
