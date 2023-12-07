package tdd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleCalculatorTest {
    @BeforeAll
    public static void init(){
        System.out.println("Trước khi thuc hien test");
    }
    @Test
    @DisplayName("Testing add 0 + 0")
    public void testAdd0And0() {
        int first = 0;
        int second = 0;
        int expected = 0;

        int result = SimpleCalculator.add(first, second);
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("Testing add 1 + 1")
    public void testAdd1And1() {
        int first = 1;
        int second = 1;
        int expected = 2;

        int result = SimpleCalculator.add(first, second);
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("Testing add 5 + 5")
    public void testAdd5And5() {
        int first = 5;
        int second = 5;
        int expected = 10;

        int result = SimpleCalculator.add(first, second);
        assertEquals(expected, result);
    }
}
