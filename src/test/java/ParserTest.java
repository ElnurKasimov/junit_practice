import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

class ParserTest {
    private Parser parser;
    Map<Character, Integer> expected;

    @BeforeEach
    public void beforeEach() {
        parser = new Parser();
        expected = new HashMap<>();
    }

    @Test
    public void testingThatGetProductQuantityReturnsMap_A_1() {
        Map<Character, Integer> actual = new Parser().getProductsQuantity("A");
        expected.put('A', 1);
        expected.put('B', 0);
        expected.put('C', 0);
        expected.put('D', 0);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testThatGetProductQuantityReturnsA1B1C1D1() {
        Map<Character, Integer> actual = parser.getProductsQuantity("DBCA");
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('A', 1);
        expected.put('B', 1);
        expected.put('C', 1);
        expected.put('D', 1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testThatGetProductQuantityReturnsA0B2C3D1() {
        Map<Character, Integer> actual =  parser.getProductsQuantity("BCCDBC");
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('A', 0);
        expected.put('B', 2);
        expected.put('C', 3);
        expected.put('D', 1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testingThatGetProductsQuantityInvalidInputHandledCorrectly() {
        String[] invalidInputs = {
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
                    () -> parser.getProductsQuantity(str));
        }
    }

}
