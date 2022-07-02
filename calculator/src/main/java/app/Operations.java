package app;

import org.graalvm.polyglot.*;

public class Operations {

    private int execute(String operation, int a, int b) {
        try (Context polyglot = Context.newBuilder().build()) {
            polyglot.eval("js", Constants.JS_SCRIPT);

            Value functions = polyglot.getBindings("js");

            Value operationFunction = functions.getMember(operation);

            return operationFunction.execute(a, b).asInt();
        }
    }

    public int sum(int a, int b) {
        return execute("sum", a, b);
    }

    public int sub(int a, int b) {
        return execute("sub", a, b);
    }

    public int multi(int a, int b) {
        return execute("multi", a, b);
    }

    public int div(int a, int b) {
        return execute("div", a, b);
    }
}
