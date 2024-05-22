package io.github.svbgabriel

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

data class ResultFactorialBody(
    @field:JsonProperty("result")
    val result: BigDecimal
)
