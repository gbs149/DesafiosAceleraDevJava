package fibonacci;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void fibonacciGeneratorTest() {
        List<Integer> fibonacciNumbers = Fibonacci.fibonacciGenerator(Arrays.asList(0, 1), 200);
        List<Integer> expected = Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144);

        assertEquals(expected, fibonacciNumbers);
    }

    @Test
    void isFibonacciTest() {
        assertAll(() -> {
            assertTrue(Fibonacci.isFibonacci(89));
            assertFalse(Fibonacci.isFibonacci(91));
        });
    }

}