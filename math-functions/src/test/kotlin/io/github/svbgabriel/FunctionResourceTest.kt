package io.github.svbgabriel

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.Matchers.containsInAnyOrder
import org.junit.jupiter.api.Test

@QuarkusTest
class FunctionResourceTest {
    @Test
    fun testFactorialEndpointNull() {
        RestAssured.given()
            .`when`()["/api/functions/factorial"]
            .then()
            .statusCode(200)
            .body("result", equalTo(1))
    }

    @Test
    fun testFactorialEndpointZero() {
        RestAssured.given()
            .`when`()["/api/functions/factorial?input=0"]
            .then()
            .statusCode(200)
            .body("result", equalTo(1))
    }

    @Test
    fun testFactorialEndpointOne() {
        RestAssured.given()
            .`when`()["/api/functions/factorial?input=1"]
            .then()
            .statusCode(200)
            .body("result", equalTo(1))
    }

    @Test
    fun testFactorialEndpoint() {
        RestAssured.given()
            .`when`()["/api/functions/factorial?input=4"]
            .then()
            .statusCode(200)
            .body("result", equalTo(24))
    }

    @Test
    fun testFibonacciEndpointNull() {
        RestAssured.given()
            .`when`()["/api/functions/fibonacci"]
            .then()
            .statusCode(200)
            .body("results", containsInAnyOrder(0))
    }

    @Test
    fun testFibonacciEndpointZero() {
        RestAssured.given()
            .`when`()["/api/functions/fibonacci?input=0"]
            .then()
            .statusCode(200)
            .body("results", containsInAnyOrder(0))
    }

    @Test
    fun testFibonacciEndpointOne() {
        RestAssured.given()
            .`when`()["/api/functions/fibonacci?input=1"]
            .then()
            .statusCode(200)
            .body("results", containsInAnyOrder(0))
    }

    @Test
    fun testFibonacciEndpoint() {
        RestAssured.given()
            .`when`()["/api/functions/fibonacci?input=10"]
            .then()
            .statusCode(200)
            .body("results", containsInAnyOrder(0, 1, 1, 2, 3, 5, 8, 13, 21, 34))
    }
}
