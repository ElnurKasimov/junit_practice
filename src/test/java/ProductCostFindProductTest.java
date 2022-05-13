import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductCostFindProductTest {
    private Shop shop;
    private ProductCost productCost;

    @BeforeEach
    public void beforeEach() {
        productCost = new ProductCost();
        shop = Shop.getInstance();
        if (shop.getProducts().isEmpty()) {
            shop.create('A', 1, 1, 2);
            shop.create('B', 2, 1.5, 2.25);
            shop.create('C', 3, 1.75, 2.75);
        }
    }

    @Test
    public void testThatFindProductByNameFindFirstProductFromTwo() {

        Assertions.assertEquals(shop.getProducts().get(0), productCost.findProductByName('A'));
    }

    @Test
    public void testThatFindProductByNameFindSecontProductFromTwo() {
        Assertions.assertEquals(shop.getProducts().get(1), productCost.findProductByName('B'));
    }

    @Test
    public void testThatFndProductByNameInvalidInputsHandledCorrectly() {
        char[] invalidInputs = {
                ' ',
                'd',
                '5',
        };
        for (char c : invalidInputs) {
            Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> productCost.findProductByName(c));
        }
    }

    @Test
    public void testThatFndProductByNameReturnsNullIfProductIsAbsent () {
        Assertions.assertThrows(
                RuntimeException.class,
                () -> productCost.findProductByName('D'));
    }

}
