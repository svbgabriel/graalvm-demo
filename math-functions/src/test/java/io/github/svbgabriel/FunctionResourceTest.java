package io.github.svbgabriel;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.containsInAnyOrder;

@QuarkusTest
public class FunctionResourceTest {

    @Test
    public void testFactorialEndpointNull() {
        given()
                .when().get("/api/functions/factorial")
                .then()
                .statusCode(200)
                .body("result", equalTo(1));
    }

    @Test
    public void testFactorialEndpointZero() {
        given()
                .when().get("/api/functions/factorial?input=0")
                .then()
                .statusCode(200)
                .body("result", equalTo(1));
    }

    @Test
    public void testFactorialEndpointOne() {
        given()
                .when().get("/api/functions/factorial?input=1")
                .then()
                .statusCode(200)
                .body("result", equalTo(1));
    }

    @Test
    public void testFactorialEndpoint() {
        given()
                .when().get("/api/functions/factorial?input=4")
                .then()
                .statusCode(200)
                .body("result", equalTo(24));
    }

    @Test
    public void testFibonacciEndpointNull() {
        given()
                .when().get("/api/functions/fibonacci")
                .then()
                .statusCode(200)
                .body("results", containsInAnyOrder(0));
    }

    @Test
    public void testFibonacciEndpointZero() {
        given()
                .when().get("/api/functions/fibonacci?input=0")
                .then()
                .statusCode(200)
                .body("results", containsInAnyOrder(0));
    }

    @Test
    public void testFibonacciEndpointOne() {
        given()
                .when().get("/api/functions/fibonacci?input=1")
                .then()
                .statusCode(200)
                .body("results", containsInAnyOrder(0));
    }

    @Test
    public void testFibonacciEndpoint() {
        given()
                .when().get("/api/functions/fibonacci?input=10")
                .then()
                .statusCode(200)
                .body("results", containsInAnyOrder(0, 1, 1, 2, 3, 5, 8, 13, 21, 34));
    }
}
