package fibonacci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fibonacci {
    private static List<Integer> fibs = fibonacciGenerator(Arrays.asList(0, 1), 350);

    static List<Integer> fibonacciGenerator(List<Integer> fibonacciNumbers, Integer maxFib) {
        Integer newFibonacci = last(fibonacciNumbers) + nextToLast(fibonacciNumbers);
        if (newFibonacci > maxFib) {
            return fibonacciNumbers;
        } else {
            List<Integer> numbers = new ArrayList<>(fibonacciNumbers);
            numbers.add(newFibonacci);
            return fibonacciGenerator(numbers, maxFib);
        }
    }

    static Boolean isFibonacci(Integer a) {
        return fibs.contains(a);
    }

    private static <T> T last(List<T> numeros) {
        return numeros.get(numeros.size() - 1);
    }

    private static <T> T nextToLast(List<T> numeros) {
        return numeros.get(numeros.size() - 2);
    }

}
