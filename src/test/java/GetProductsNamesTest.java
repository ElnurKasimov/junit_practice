import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GetProductsNamesTest {
    private Shop shop;

    @BeforeEach
    public void beforeEach() {
        shop = new Shop();
    }

    @Test
    public void testThatGetProductsNamesMethodWorsOkForA() {
    char[] actual  = shop.getProductsNames("A");
    char[] expected = {'A'};
    Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testThatGetProductsNamesMethodWorsOkForAABAA() {
        char[] actual  = shop.getProductsNames("AABAA");
        char[] expected = {'A', 'A', 'B', 'A', 'A'};
        Assertions.assertArrayEquals(expected, actual);
    }

      @Test
    public void testThatGetProductsNamesInputFromAToDHandledCorrectly() {
        String[] invalidInputs = {
                null,
                "",
                " ",
                "7",
                "c",
                "A B",
                " D",
                "3DDD",
                "A+B"
        };
        for (String str :invalidInputs) {
            Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> shop.getProductsNames(str));
        }
    }

}