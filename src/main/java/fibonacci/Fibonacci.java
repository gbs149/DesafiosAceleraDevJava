package fibonacci;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Fibonacci {
    private static final List<Integer> FIBONACCI_STARTER = IntStream.rangeClosed(0, 1).boxed().collect(Collectors.toList());

    private static List<Integer> fibonacciNumbers = fibonacciGenerator(FIBONACCI_STARTER);

    public static Boolean isFibonacci(Integer a) {
        return fibonacciNumbers.contains(a);
    }

    public static List<Integer> fibonacciGenerator(List<Integer> fibonacciNumbers) {
        Integer newFibonacci = last(fibonacciNumbers) + nextToLast(fibonacciNumbers);
        if (newFibonacci > 350) {
            return fibonacciNumbers;
        }
        fibonacciNumbers.add(newFibonacci);
        return fibonacciGenerator(fibonacciNumbers);
    }

    private static Integer last(List<Integer> list) {
        return list.get(list.size() - 1);
    }

    private static Integer nextToLast(List<Integer> list) {
        return list.get(list.size() - 2);
    }
}
