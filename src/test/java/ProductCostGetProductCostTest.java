import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductCostGetProductCostTest {
    private Shop shop;
    private ProductCost productCost;

    @BeforeEach
    public void beforeEach() {
        productCost = new ProductCost();
        shop = Shop.getInstance();
        if (shop.getProducts().isEmpty()) {
            shop.create('A', 2, 1, 1.5);
            shop.create('B', 4, 1.5, 2.25);
            shop.create('C', 3, 1.5, 3.0);
            shop.create('D', 0, 1.5, 0);
        }
    }

    @Test
    public void testingThatProductCostNameInvalidInputHandledCorrectly() {
        char[] invalidInputs = {
                ' ',
                'd',
                '5',
        };
        for (char c : invalidInputs) {
            Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> productCost.getProductCost(c, 1));
        }
    }

    @Test
    public void testingThatProductCostQuantityInvalidInputHandledCorrectly() {
        Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> productCost.getProductCost('A', -1));
    }

    @Test
    public void testingThatProductCostQuantityWorksCorrectlyWhenPromotionalItemQuality_0() {
        double actual = productCost.getProductCost('D', 3);
        double expected = 4.5;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testingThatProductCostReturnPriceProductWhenQuantityDiffersFromPromotionalQuantity() {
        double actual = productCost.getProductCost('A', 3);
        double expected = 3;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testingThatProductCostReturnPriceProductWhenQuantityEqualPromotionalQuantity() {
        double actual = productCost.getProductCost('B', 4);
        double expected = 2.25;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testingThatProductCostReturnPriceProductWhenQuantityMultiplyPromotionalQuantity() {
        double actual = productCost.getProductCost('C', 6);
        double expected = 6.;
        Assertions.assertEquals(expected, actual);
    }

}
