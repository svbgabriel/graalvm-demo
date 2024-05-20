package hello;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

public class HelloWorldPY {
    public static void main(String[] args) {
        System.out.println("Hello from Java on GraalVM!");
        try (Context polyglot = Context.newBuilder().build()) {
            polyglot.eval("python", "print('Hello from Python!');");
            final Value array = polyglot.eval("python", "[10,22,33,42,49,55]");
            for (int i = 0; i < array.getArraySize(); i++) {
                final int number = array.getArrayElement(i).asInt();
                final String message = "This number came from a Python array: " + number + "!";
                System.out.println(message);
            }
        }
    }
}
