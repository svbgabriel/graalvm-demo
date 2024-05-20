package app;

public class Calculator {
    public static void main(String[] args) {
        final Operations operations = new Operations();

        System.out.println(operations.sum(1, 2));
        System.out.println(operations.sub(9, 2));
        System.out.println(operations.multi(3, 3));
        System.out.println(operations.div(4, 2));
        System.out.println(operations.div(4, 0));
    }
}
