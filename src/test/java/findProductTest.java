import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class findProductTest {
    private Shop shop;

    @BeforeEach
    public void beforeEach() {
        shop = new Shop();
        shop.create('A', 1, 1, 2);
        shop.create('B', 2, 1.5, 2.25);
        shop.create('C', 3, 1.75, 2.75);
    }

    @Test
    public void testThatFindProductByNameFindFirstProductFromTwo() {

        Assertions.assertEquals(shop.getProducts().get(0), shop.findProductByName('A'));
    }

    @Test
    public void testThatFindProductByNameFindSecontProductFromTwo() {
        Assertions.assertEquals(shop.getProducts().get(1), shop.findProductByName('B'));
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
                    () -> shop.findProductByName(c));
        }
    }
        @Test
        public void testThatFndProductByNameReturnsNullIfProductIsAbsent () {
            Assertions.assertThrows(
                    RuntimeException.class,
                    () -> shop.findProductByName('D'));
        }
}
