package fibonacci;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void fibonacciGeneratorTest() {
        List<Integer> starter = IntStream.rangeClosed(0, 1).boxed().collect(Collectors.toList());
        List<Integer> fibonacciNumbers = Fibonacci.fibonacciGenerator(starter);
        List<Integer> expected = Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233);

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