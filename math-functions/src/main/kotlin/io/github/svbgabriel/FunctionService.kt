package io.github.svbgabriel

import jakarta.enterprise.context.ApplicationScoped
import java.math.BigDecimal

@ApplicationScoped
class FunctionService {
    fun factorial(value: Long): ResultFactorialBody {
        if (value <= 1) {
            return ResultFactorialBody(BigDecimal.ONE)
        }

        val result = 1L.rangeTo(value)
            .map { it.toBigDecimal() }
            .fold(BigDecimal.ONE) { acc, next -> acc * next  }

        return ResultFactorialBody(result)
    }

    fun fibonacci(value: Long): ResultFibonacciBody {
        val results = mutableListOf<BigDecimal>()

        if (value >= 0) {
            results.add(BigDecimal.ZERO)
        }

        if (value >= 2) {
            results.add(BigDecimal.ONE)
        }

        if (value >= 3) {
            var n1 = BigDecimal.ZERO
            var n2 = BigDecimal.ONE
            var n3: BigDecimal
            for (i in 2 until value) {
                n3 = n1.add(n2)
                results.add(n3)
                n1 = n2
                n2 = n3
            }
        }

        return ResultFibonacciBody(results)
    }
}
