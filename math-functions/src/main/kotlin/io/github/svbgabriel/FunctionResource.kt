package io.github.svbgabriel

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import org.jboss.resteasy.reactive.RestQuery

@Path("/api/functions")
class FunctionResource(private val functionService: FunctionService) {
    @GET
    @Path("factorial")
    @Produces(MediaType.APPLICATION_JSON)
    fun factorial(@RestQuery("input") value: Long): ResultFactorialBody {
        return functionService.factorial(value)
    }

    @GET
    @Path("fibonacci")
    @Produces(MediaType.APPLICATION_JSON)
    fun fibonacci(@RestQuery("input") value: Long): ResultFibonacciBody {
        return functionService.fibonacci(value)
    }
}
