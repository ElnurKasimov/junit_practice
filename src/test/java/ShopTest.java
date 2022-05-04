import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShopTest {

    @Test
    public void testThatGetProductsNamesMethodWorsOkForA() {
    char[] actual  = new Shop().getProductsNames("A");
    char[] expected = {'A'};
    Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testThatGetProductsNamesReturnsUpperCaseOnly() {

    }

    @Test
    public void testThatGetProductsNamesReturnsFromAToD() {

    }

}