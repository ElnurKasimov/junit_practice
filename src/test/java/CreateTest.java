import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


//the name of a class can't be a verb it should be noun
public class CreateTest {
    private Shop shop;

    @BeforeEach
    public void beforeEach() {
        shop = new Shop();
    }

      @Test
    public void testThatCreateInputNameHandledCorretly() {
          char[] invalidInputs = {
                  ' ',
                  //
         //      'ф',     компилятор выдает  error: unclosed character literal. Поменял кодировку на UTF-8 - не помогло.
                           //  перепробовал кучу других кодировок - не помогает
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
    public void testThatCreateInputPromotionalQuantityHandledCorretly() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> shop.create('C', -1, 1., 2.));
    }

    @Test
    public void testThatCreateInputPriceHandledCorretly() {
        double[] invalidInputs = {0., -1.};
        for (double v :invalidInputs) {
            Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> shop.create('C', 1, v, 2.));
        }
    }

    @Test
    public void testThatCreateInputPromotionalPriceHandledCorretly() {
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
    public void testThatCreateInputNonUniqueNameHandledCorretly() {
        shop.create('A', 1, 1, 2);
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> shop.create('A', 0, 1.34, 2.12));
    }




}
