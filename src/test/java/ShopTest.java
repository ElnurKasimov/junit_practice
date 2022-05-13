import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopTest {
    private Shop shop;

    @BeforeEach
    public void beforeEach() {
        shop = Shop.getInstance();
    }

      @Test
    public void testingThatCreateInputNameHandledCorretly() {
          char[] invalidInputs = {
                  ' ',
                  'd',
                  'F',
                  '5',
          };
          for (char c :invalidInputs) {
              Assertions.assertThrows(
                      IllegalArgumentException.class,
                      () -> shop.create(c, 1, 1., 2.));
          }
       }

    @Test
    public void testingThatCreateInputPromotionalQuantityHandledCorretly() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> shop.create('C', -1, 1., 2.));
    }

    @Test
    public void testingThatCreateInputPriceHandledCorretly() {
        double[] invalidInputs = {0., -1.};
        for (double v :invalidInputs) {
            Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> shop.create('C', 1, v, 2.));
        }
    }

    @Test
    public void testingThatCreateInputPromotionalPriceHandledCorretly() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> shop.create('C', 1, 12., -2.));

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> shop.create('C', 0, 12., 2.));

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> shop.create('C', 1, 12.124, 12.125));
    }

    @Test
    public void testingThatCreateInputNonUniqueNameHandledCorretly() {
        shop.create('A', 1, 1, 2);
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> shop.create('A', 0, 1.34, 2.12));
    }

}
