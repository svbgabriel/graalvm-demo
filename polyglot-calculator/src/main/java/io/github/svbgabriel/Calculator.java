package io.github.svbgabriel;

public class Calculator {
    public static void main(String[] args) {
        System.out.println(Operations.sum(1, 2));
        System.out.println(Operations.sub(9, 2));
        System.out.println(Operations.multi(3, 3));
        System.out.println(Operations.div(4, 2));
        System.out.println(Operations.div(4, 0));
    }
}
