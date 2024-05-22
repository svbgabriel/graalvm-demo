package io.github.svbgabriel

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

data class ResultFibonacciBody(
    @field:JsonProperty("results")
    val results: List<BigDecimal>
)
