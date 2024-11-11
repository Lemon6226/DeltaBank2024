package org.delta.investment;

public class Investment {

    private final String type;
    private final double amount;
    private final double rate;



    public Investment(String type, double amount, double rate) {
        this.type = type;
        this.amount = amount;
        this.rate = rate;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getRate() {
        return rate;
    }

    public double calculateReturn() {
        return amount * rate;
    }
}