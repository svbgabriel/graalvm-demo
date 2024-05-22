package io.github.svbgabriel;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

import java.util.OptionalInt;

public class Operations {

    private Operations() {}

    private static int execute(String operation, int a, int b) {
        try (Context polyglot = Context.newBuilder().build()) {
            polyglot.eval("js", Constants.JS_SCRIPT);

            Value functions = polyglot.getBindings("js");

            Value operationFunction = functions.getMember(operation);

            return operationFunction.execute(a, b).asInt();
        }
    }

    public static int sum(int a, int b) {
        return execute("sum", a, b);
    }

    public static int sub(int a, int b) {
        return execute("sub", a, b);
    }

    public static int multi(int a, int b) {
        return execute("multi", a, b);
    }

    public static OptionalInt div(int a, int b) {
        if (b == 0) {
           return OptionalInt.empty();
        }

        return OptionalInt.of(execute("div", a, b));
    }
}
