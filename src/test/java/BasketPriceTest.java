import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasketPriceTest {
    private Shop shop;
    private ProductCost productCost;
    private BasketPrice basketPrice;

    @BeforeEach
    public void beforeEach() {
        productCost = new ProductCost();
        shop = Shop.getInstance();
        if (shop.getProducts().isEmpty()) {
            shop.create('A', 2, 1, 1.5);
            shop.create('B', 4, 1.5, 2.25);
            shop.create('C', 3, 1.5, 3.0);
            shop.create('D', 0, 0.75, 0);
        }
        basketPrice = new BasketPrice();
    }

    @Test
    public void testThatCalculateTotalCostInvalidInputDHandledCorrectly() {
        String[] invalidInputs = {
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
                    () -> basketPrice.calculateTotalCost(str));
        }
    }

    @Test
    public void testThatCalculateTotalCostReturns_PromotionalPrice_For_A() {
        double actual = basketPrice.calculateTotalCost("A");
        double expected = 1.0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testThatCalculateTotalCostReturns_ThreePromotionalPrice_For_BBBB() {
        double actual = basketPrice.calculateTotalCost("BBBB");
        double expected = 2.25;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testThatCalculateTotalCostWQorksRightFor_ABACD() {
        double actual = basketPrice.calculateTotalCost("ABACD");
        double expected = 5.25;
        Assertions.assertEquals(expected, actual);
    }

}
