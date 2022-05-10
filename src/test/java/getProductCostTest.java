import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

//class should start only with capital letter
//the name of a class can't be a verb it should be noun
public class getProductCostTest {
    private Shop shop;

    @BeforeEach
    public void beforeEach() {
        shop = new Shop();
    }

    @Test
    public void testThatProductCostNameInvalidInputHandledCorrectly() {
        shop.create('A', 1, 1, 2);
        shop.create('B', 1, 1, 2);
        char[] invalidInputs = {
                ' ',
                'd',
                '5',
        };
        for (char c : invalidInputs) {
            Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> shop.getProductCost(c, 1));
        }
    }

    @Test
    public void testThatProductCostQuantityInvalidInputHandledCorrectly() {
        shop.create('A', 1, 1, 2);
        Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> shop.getProductCost('A', -1));
    }

    @Test
    public void testThatProductCostReturnPriceProductWhithoutPromotional() {
        shop.create('A', 0, 1.25, 0);
        double actual = shop.getProductCost('A', 2);
        double expected = 2.5;
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void testThatProductCostReturnPriceProductAccordingPromotional() {
        shop.create('A', 1, 1.25, 2.3);
        double actual = shop.getProductCost('A', 4);
        double expected = 6.05;
        Assertions.assertEquals(expected, actual);
    }
}
