package org.delta.investment;

public class InvestmentFactory {

    public InvestmentService createAppleInvestment(double amount) {
        return new InvestmentService("Apple", amount * 0.4, 0.04);
    }

    public InvestmentService createAlphabetInvestment(double amount) {
        return new InvestmentService("Alphabet", amount * 0.4, 0.02);
    }

    public InvestmentService createMetaInvestment(double amount) {
        return new InvestmentService("Meta", amount * 0.2, 0.01);
    }
}