package org.delta.investment;

public class InvestmentFactory {

    public Investment createAppleInvestment(double amount) {
        return new Investment("Apple", amount * 0.4, 0.04);
    }

    public Investment createAlphabetInvestment(double amount) {
        return new Investment("Alphabet", amount * 0.4, 0.02);
    }

    public Investment createMetaInvestment(double amount) {
        return new Investment("Meta", amount * 0.2, 0.01);
    }
}