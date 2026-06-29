package week3.tdd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void add_shouldReturnSumOfTwoNumbers() {
        assertEquals(8, calculator.add(5, 3));
    }

    @Test
    public void subtract_shouldReturnDifferenceOfTwoNumbers() {
        assertEquals(2, calculator.subtract(5, 3));
    }
}
