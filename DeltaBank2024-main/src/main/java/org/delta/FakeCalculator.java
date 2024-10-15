package org.delta;

public class FakeCalculator implements  Calc{
    @Override
    public double add(double a, double b) {
        return 0;
    }

    @Override
    public double sub(double a, double b) {
        return 0;
    }

    @Override
    public double mul(double a, double b) {
        return 0;
    }

    @Override
    public double div(double a, double b) {
        return 0;
    }
}
