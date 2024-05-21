package io.github.svbgabriel;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
