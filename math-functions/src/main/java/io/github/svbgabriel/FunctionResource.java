package io.github.svbgabriel;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.jboss.resteasy.reactive.RestQuery;

@Path("/api/functions")
public class FunctionResource {

    @Inject
    FunctionService functionService;

    @GET
    @Path("factorial")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultFactorialBody factorial(@RestQuery("input") final Long value) {
        return functionService.factorial(value);
    }

    @GET
    @Path("fibonacci")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultFibonacciBody fibonacci(@RestQuery("input") final Long value) {
        return functionService.fibonacci(value);
    }
}
