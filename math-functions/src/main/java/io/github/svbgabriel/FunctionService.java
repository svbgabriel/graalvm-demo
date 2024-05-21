package io.github.svbgabriel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FunctionService {

    public ResultFactorialBody factorial(final Long value) {
        if (value == null || value <= 1) {
            return new ResultFactorialBody(BigDecimal.ONE);
        }

        final BigDecimal result = LongStream.rangeClosed(1, value)
                .mapToObj(v -> new BigDecimal(v))
                .reduce(BigDecimal.ONE, (a, b) -> a.multiply(b));

        return new ResultFactorialBody(result);
    }

    public ResultFibonacciBody fibonacci(final Long value) {
        if (value == null) {
            return new ResultFibonacciBody(List.of(BigDecimal.ZERO));
        }

        final List<BigDecimal> results = new ArrayList<>();

        if (value >= 0) {
            results.add(BigDecimal.ZERO);
        }

        if (value >= 2) {
            results.add(BigDecimal.ONE);
        }

        if (value >= 3) {
            BigDecimal n1 = BigDecimal.ZERO;
            BigDecimal n2 = BigDecimal.ONE;
            BigDecimal n3;
            for (int i = 2; i < value; ++i) {
                n3 = n1.add(n2);
                results.add(n3);
                n1 = n2;
                n2 = n3;
            }
        }

        return new ResultFibonacciBody(results);
    }
}
