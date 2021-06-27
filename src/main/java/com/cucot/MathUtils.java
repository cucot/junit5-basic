package com.cucot;

public class MathUtils {

    public int add(int a, int b) {
        if ((a / 2.0 + b / 2.0) > Integer.MAX_VALUE / 2.0) {
            throw new RuntimeException("Exceed Integer.MAX_VALUE");
        }
        if (((a/2.0 + b/2.0) < Integer.MIN_VALUE/2.0)) {
            throw new RuntimeException("Result less than Integer.MIN_VALUE");
        }
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println("Hello, motor");
        MathUtils mathUtils = new MathUtils();
        System.out.println(mathUtils.add(Integer.MAX_VALUE, 1));
    }
}
