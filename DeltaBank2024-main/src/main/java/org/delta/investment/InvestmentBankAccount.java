package org.delta.investment;

import org.delta.acounts.BankAccount;
import org.delta.investment.InvestmentService;
import org.delta.persons.Owner;

import java.util.ArrayList;
import java.util.List;

public class InvestmentBankAccount extends BankAccount {

    private final List<InvestmentService> investments;

    public InvestmentBankAccount(double balance, Owner owner, String accountNumber) {
        super(balance, owner, accountNumber);
        this.investments = new ArrayList<>();
    }

    public List<InvestmentService> getInvestments() {
        return investments;
    }

    public void addInvestment(InvestmentService investment) {
        investments.add(investment);
    }
}
