package org.delta;

public class Calculator implements Calc {
    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double sub(double a, double b) {
        return a - b;
    }

    @Override
    public double mul(double a, double b) {
        return a * b;
    }

    @Override
    public double div(double a, double b) {

        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }

        return a / b;
    }
}
